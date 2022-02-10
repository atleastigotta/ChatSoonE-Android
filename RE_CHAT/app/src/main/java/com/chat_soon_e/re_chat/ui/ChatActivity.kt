package com.chat_soon_e.re_chat.ui

import android.annotation.SuppressLint
import android.graphics.Insets
import android.graphics.Point

import android.util.Log
import android.view.*
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.PopupMenu
import android.widget.PopupWindow
import androidx.activity.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.chat_soon_e.re_chat.ApplicationClass
import com.chat_soon_e.re_chat.ApplicationClass.Companion.DELETED
import com.chat_soon_e.re_chat.R
import com.chat_soon_e.re_chat.data.entities.Chat
import com.chat_soon_e.re_chat.data.local.AppDatabase
import com.chat_soon_e.re_chat.data.entities.ChatList
import com.chat_soon_e.re_chat.data.entities.Folder
import com.chat_soon_e.re_chat.databinding.ActivityChatBinding
import com.chat_soon_e.re_chat.utils.getID
import com.chat_soon_e.re_chat.databinding.ItemFolderListBinding

class ChatActivity: BaseActivity<ActivityChatBinding>(ActivityChatBinding::inflate) {
    private var isFabOpen = false    // FAB(FloatingActionButton)가 열렸는지 체크해주는 변수
    private lateinit var fabOpen: Animation
    private lateinit var fabClose: Animation
    private lateinit var database: AppDatabase
    private var folderList = ArrayList<Folder>()
    private lateinit var chatRVAdapter: ChatRVAdapter
    private val chatViewModel: ChatViewModel by viewModels()
    private lateinit var mPopupWindow: PopupWindow
    private var chatList = ArrayList<Chat>()
    private lateinit var chatListData:ChatList
    private var isGroup:Boolean=false
    private var isAll:Int=0 //모든 채팅을 불러오는지(1), 각 채팅방을 불러오는 것인지(-1)

    override fun initAfterBinding() {
        //initData()
        initFab()
        initData()
        initRecyclerView()
        initClickListener()
    }

    // test chat 초기화 (테스트용)
    private fun initTestChat() {
        if(chatList.isNotEmpty()) return
    }

    // FAB 애니메이션 초기화
    private fun initFab() {
        fabOpen = AnimationUtils.loadAnimation(this, R.anim.fab_open)
        fabClose = AnimationUtils.loadAnimation(this, R.anim.fab_close)
    }

    // RecyclerView
    private fun initRecyclerView() {
        database = AppDatabase.getInstance(this)!!
        chatRVAdapter = ChatRVAdapter(this, object: ChatRVAdapter.MyItemClickListener {
            // 채팅 삭제
            override fun onRemoveChat(position: Int) {
                database.chatDao().deleteByChatIdx(chatList[position].chatIdx)
            }

            // 채팅 롱클릭 시 팝업 메뉴 뜨도록
            override fun onDefaultChatLongClick(popupMenu: PopupMenu) {
                chatRVAdapter.clearSelectedItemList()
                popupMenu.show()
            }

            // 선택 모드
            override fun onChooseChatClick(view: View, position: Int) {
                chatRVAdapter.setChecked(position)
            }
        })

        chatViewModel.mode.observe(this, {
            if(it == 0) {
                // 일반 모드
                chatRVAdapter.clearSelectedItemList()
            } else {
                // 선택 모드
                chatRVAdapter.clearSelectedItemList()
            }
            // 모든 데이터의 viewType 바꿔주기
            chatRVAdapter.setViewType(currentMode = it)
        })

        // 어댑터 연결
        binding.chatChatRecyclerView.adapter = chatRVAdapter
        if(chatListData.groupName=="null")
            database.chatDao().getOneChatList(getID(), chatListData.chatIdx).observe(this,{
                chatRVAdapter.addItem(it)
                Log.d("RValllllllllll", it.toString())
            })
        else
            database.chatDao().getOrgChatList(getID(), chatListData.chatIdx).observe(this,{
                chatRVAdapter.addItem(it)
                Log.d("RValllllllllll", it.toString())
            })

        // 폴더 선택 모드를 해제하기 위해
        binding.chatCancelFab.setOnClickListener {
            binding.chatMainFab.setImageResource(R.drawable.ic_folder)
            binding.chatCancelFab.startAnimation(fabClose)
            binding.chatCancelFab.isClickable = false
            isFabOpen = false
            binding.chatBackgroundView.visibility = View.INVISIBLE

            // 일반 모드로
            chatRVAdapter.clearSelectedItemList()
            chatViewModel.setMode(mode = 0)
        }
   }

    private fun initClickListener() {
        // 메인 FAB 버튼 눌렀을 때
        binding.chatMainFab.setOnClickListener {
            if(chatViewModel.mode.value == 0) {
                chatViewModel.setMode(mode = 1)
            } else {
                chatViewModel.setMode(mode = 0)
            }

            if(isFabOpen) {
                // fab 버튼이 열려있는 경우 (선택 모드에서 클릭했을 때)
                // 폴더로 보내는 팝업창을 띄운다.
                // 여기서 view는 클릭된 뷰를 의미한다.
                popupWindowToFolderMenu()
            } else {
                // fab 버튼이 닫혀있는 경우 (일반 모드에서 클릭했을 때)
                binding.chatMainFab.setImageResource(R.drawable.ic_to_folder)
                binding.chatCancelFab.startAnimation(fabOpen)
                binding.chatCancelFab.isClickable = true
                isFabOpen = true
            }
        }

        binding.chatBackIv.setOnClickListener {
            finish()
        }
    }
    //MainActivity로 부터 데이터를 가져온다.

    private fun initData(){
        // isAll : 모든 채팅 목록==-1, 특정 채팅방 목록==1
        isAll=getSharedPreferences("chatAll", MODE_PRIVATE).getInt("chatAll", 0)
        if(intent.hasExtra("chatListJson")){
            chatListData=intent.getSerializableExtra("chatListJson") as ChatList
            if(chatListData.groupName==null ||chatListData.groupName=="null")
                binding.chatNameTv.text=chatListData.nickName
            else
                binding.chatNameTv.text=chatListData.groupName
            Log.d("chatListInitData", chatListData.toString())
        }

    }

    override fun onBackPressed() {
//        startActivity(Intent(this,MainActivity::class.java))
        finish()
    }

    // 폴더로 보내기 팝업 윈도우
    @SuppressLint("InflateParams")
    private fun popupWindowToFolderMenu() {
        folderList = database.folderDao().getFolderList() as ArrayList

        // 팝업 윈도우 사이즈를 잘못 맞추면 아이템들이 안 뜨므로 하드 코딩으로 사이즈 조정해주기
        // 아이콘 16개 (기본)
        val size = windowManager.currentWindowMetricsPointCompat()
        val width = (size.x * 0.8f).toInt()
        val height = (size.y * 0.4f).toInt()

        val inflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val popupView = inflater.inflate(R.layout.popup_window_to_folder_menu, null)
        mPopupWindow = PopupWindow(popupView, width, height)

        mPopupWindow.animationStyle = -1        // 애니메이션 설정 (-1: 설정 안 함, 0: 설정)
        mPopupWindow.isFocusable = true         // 외부 영역 선택 시 팝업 윈도우 종료
        mPopupWindow.isOutsideTouchable = true
        mPopupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0)
        mPopupWindow.setOnDismissListener(PopupWindowDismissListener())
        binding.chatBackgroundView.visibility = View.VISIBLE

        // RecyclerView 구분선
        val recyclerView = popupView.findViewById<RecyclerView>(R.id.popup_window_to_folder_menu_recycler_view)
        val dividerItemDecoration =
            DividerItemDecoration(recyclerView.context, DividerItemDecoration.VERTICAL)
        recyclerView.addItemDecoration(dividerItemDecoration)

        // RecyclerView 초기화
        // 더미 데이터와 어댑터 연결
        val folderListRVAdapter = FolderListRVAdapter()
        recyclerView.adapter = folderListRVAdapter
        folderListRVAdapter.setMyItemClickListener(object: FolderListRVAdapter.MyItemClickListener {
            override fun onFolderClick(itemBinding: ItemFolderListBinding, itemPosition: Int) {
                // 이동하고 싶은 폴더 클릭 시 폴더로 채팅 이동 (뷰에는 그대로 남아 있도록)
                val selectedFolder = folderList[itemPosition]
                if (selectedFolder.status == ApplicationClass.HIDDEN) {
                    val lockSPF = getSharedPreferences("lock", 0)
                    val pattern = lockSPF.getString("pattern", "0")

                    // 패턴 모드 확인
                    // 0: 숨긴 폴더 목록을 확인하기 위한 입력 모드
                    // 1: 메인 화면의 설정창 -> 변경 모드
                    // 2: 폴더 화면의 설정창 -> 변경 모드
                    // 3: 메인 화면 폴더로 보내기 -> 숨김 폴더 눌렀을 경우
                    val modeSPF = getSharedPreferences("mode", 0)
                    val editor = modeSPF.edit()

                    // 여기서는 3번 모드
                    editor.putInt("mode", 3)
                    editor.apply()

                    if(pattern.equals("0")) {   // 패턴이 설정되어 있지 않은 경우 패턴 설정 페이지로
                        startNextActivity(CreatePatternActivity::class.java)
                    } else {    // 패턴이 설정되어 있는 경우 입력 페이지로 (보안을 위해)
                        startNextActivity(InputPatternActivity::class.java)
                    }
                }
                //만약 비밀번호가 틀렸을경우 제대로 취소가 되는지 확인
                // 폴더로 이동시키는 코드 작성
                var selectedChatIdx=chatRVAdapter.getSelectedItemList()
                for(i in selectedChatIdx){
                    database.folderContentDao().insertChat(folderList[itemPosition].idx, i)
                }
                val TG="moveListcontent"
                Log.d(TG, "해당 폴더 목록"+database.folderContentDao().getAllfolder().toString())

                // 팝업 윈도우를 꺼주는 역할
                mPopupWindow.dismiss()
                binding.chatBackgroundView.visibility = View.INVISIBLE
            }
        })
        folderListRVAdapter.addFolderList(database.folderDao().getFolderExceptDeletedFolder(DELETED) as ArrayList)
    }

    // 디바이스 크기에 사이즈를 맞추기 위한 함수
    private fun WindowManager.currentWindowMetricsPointCompat(): Point {
        return if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.R) {
            val windowInsets = currentWindowMetrics.windowInsets
            var insets: Insets = windowInsets.getInsets(WindowInsets.Type.navigationBars())
            windowInsets.displayCutout?.run {
                insets = Insets.max(insets, Insets.of(safeInsetLeft, safeInsetTop, safeInsetRight, safeInsetBottom))
            }
            val insetsWidth = insets.right + insets.left
            val insetsHeight = insets.top + insets.bottom
            Point(currentWindowMetrics.bounds.width() - insetsWidth, currentWindowMetrics.bounds.height() - insetsHeight)
        } else{
            Point().apply {
                defaultDisplay.getSize(this)
            }
        }
    }

    inner class PopupWindowDismissListener(): PopupWindow.OnDismissListener {
        override fun onDismiss() {
            binding.chatBackgroundView.visibility = View.INVISIBLE
        }
    }
}