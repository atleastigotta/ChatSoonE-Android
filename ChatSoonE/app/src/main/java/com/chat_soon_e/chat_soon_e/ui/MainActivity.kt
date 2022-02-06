package com.chat_soon_e.chat_soon_e.ui

import android.annotation.SuppressLint
import android.util.Log
import androidx.recyclerview.widget.DividerItemDecoration
import com.chat_soon_e.chat_soon_e.data.entities.Chat
import com.chat_soon_e.chat_soon_e.data.local.AppDatabase
import com.chat_soon_e.chat_soon_e.databinding.ActivityMainBinding

import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Insets
import android.graphics.Point
import android.graphics.Rect
import android.os.Build
import android.util.Base64
import android.util.SparseBooleanArray
import android.view.*
import android.widget.PopupMenu
import android.widget.PopupWindow
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationManagerCompat
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.activity.viewModels
import com.chat_soon_e.chat_soon_e.data.remote.auth.USER_ID
import java.util.*
import kotlin.collections.ArrayList

import androidx.appcompat.widget.SwitchCompat
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.chat_soon_e.chat_soon_e.R
import com.chat_soon_e.chat_soon_e.data.entities.ChatList
import com.chat_soon_e.chat_soon_e.data.entities.Folder
import com.chat_soon_e.chat_soon_e.databinding.ItemFolderListBinding
import com.chat_soon_e.chat_soon_e.utils.getID
import com.chat_soon_e.chat_soon_e.utils.permissionGrantred
import com.google.android.material.navigation.NavigationView
import com.google.gson.Gson
import okhttp3.internal.notify
import java.security.MessageDigest

class MainActivity: BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate), NavigationView.OnNavigationItemSelectedListener {
//    private lateinit var chatDB: AppDatabase            // chat list를 담고 있는 데이터베이스
    private lateinit var appDB: AppDatabase
    private var folderList = ArrayList<Folder>()
    private lateinit var mainRVAdapter: MainRVAdapter   // chat list recycler view adpater
    private var chatList = ArrayList<ChatList>()            // 데이터베이스로부터 chat list를 받아올 변수
    private var permission: Boolean = true              // 알림 허용 변수
    private var selectedItem=ArrayList<ChatList>()           //선택된 chatList를 담고 있는 Array
    // ViewModel
    private val chatViewModel: ChatViewModel by viewModels()
    private lateinit var mPopupWindow: PopupWindow

    // onCreate() 이후
    override fun initAfterBinding() {
        Log.d("MAIN/LIFE-CYCLE", "after onCreate()")
    }

    // initAfterBinding() 이후 실행
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onStart() {
        super.onStart()
        Log.d("MAIN/LIFE-CYCLE", "onStart()")

        //initNotificationListener()  // NotificationListener (알림 권한 허용)
        //initChatList()              // chat list 데이터 초기화
        initFolder()
        initRecyclerView()          // RecylcerView Adapter 연결 & 기타 설정
        initDrawerLayout()          // 설정 메뉴창 설정
        initClickListener()         // 여러 ClickListener 초기화
    }

    // 폴더 초기화
    private fun initFolder() {
        appDB = AppDatabase.getInstance(this)!!
        folderList = appDB.folderDao().getFolderList() as ArrayList

        // 서버 동기화 -> 폴더 리스트 불러 오는?
        // 만약 데이터베이스에서 받아온 folder list가 비어있는 경우
        // 더미 데이터
        if (folderList.isEmpty()) {
            appDB.folderDao()
                .insert(Folder(0, 0, null, "추억", R.drawable.ic_baseline_folder_24, "active"))
            appDB.folderDao()
                .insert(Folder(1, 0, null, "여행", R.drawable.ic_baseline_folder_24, "active"))
            appDB.folderDao()
                .insert(Folder(2, 0, null, "음식", R.drawable.ic_baseline_folder_24, "active"))
            appDB.folderDao()
                .insert(Folder(3, 0, null, "학교", R.drawable.ic_baseline_folder_24, "active"))
            appDB.folderDao()
                .insert(Folder(4, 0, null, "게임", R.drawable.ic_baseline_folder_24, "active"))
            folderList = appDB.folderDao().getFolderList() as ArrayList
        }
    }

    // chat list를 불러와 화면의 띄워주는 역할
//    private fun initChatList() {
//        if(chatList.isNotEmpty()) return
//
//        val database = AppDatabase.getInstance(this)!!
//        val chatDB = database.chatDao().getRecentChat(USER_ID)
//        chatList.addAll(chatDB)
//        Log.d("DBCHECK", chatDB.toString())
//
//    }

    // RecyclerView
    private fun initRecyclerView() {
        // RecyclerView 구분선
        val recyclerView = binding.mainContent.mainChatListRecyclerView
        val dividerItemDecoration =
            DividerItemDecoration(recyclerView.context, DividerItemDecoration.VERTICAL)
        recyclerView.addItemDecoration(dividerItemDecoration)

        //LinearLayoutManager 설정, 새로운 데이터 추가 시 스크롤 맨 위로
        val linearLayoutManager= LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true)
        linearLayoutManager.stackFromEnd=true
        binding.mainContent.mainChatListRecyclerView.layoutManager=linearLayoutManager

        // RecyclerView Click Listener
        mainRVAdapter = MainRVAdapter(this, object: MainRVAdapter.MyItemClickListener {
            // 선택 모드
            override fun onChooseChatClick(view: View, position: Int) {
                //해당 item이 선택됬을 떄의 행동을 정의
                mainRVAdapter.setChecked(position)
            }
            // 이동 모드
            @SuppressLint("RestrictedApi")
            override fun onDefaultChatClick(view: View, position: Int, chat:ChatList) {
                val gson= Gson()
                val chatJson=gson.toJson(chat)
                startActivity(Intent(this@MainActivity, ChatActivity::class.java).apply {
                    putExtra("chatListJson", chatJson)
                })

//                startNextActivity(Intent(this@MainActivity, ChatActivity::class.java).apply {
//                    putExtraData("chatListJson", chatJson)
//                })
                mainRVAdapter.clearSelectedItemList()
                //눌렀을 경우 chatIdx의 isNew를 바꾼다.
                val database=AppDatabase.getInstance(this@MainActivity)!!
                database.chatDao().updateIsNew(chatList[position].chatIdx,1)
                database.chatListDao().updateIsNew(chatList[position].chatIdx, 1)
                Log.d("chatSelectedNew", database.chatDao().getChatByChatIdx(chatList[position].chatIdx).toString())
                Log.d("chatSelectedNewChatList", chatList[position].isNew.toString())

            }
        })

        chatViewModel.mode.observe(this, {
            if(it == 0) {
                // 일반 모드
                mainRVAdapter.clearSelectedItemList()
                binding.mainContent.mainFolderIv.visibility = View.VISIBLE
                binding.mainContent.mainFolderModeIv.visibility = View.GONE
                binding.mainContent.mainUpdateIv.visibility = View.VISIBLE
                binding.mainContent.mainCancelIv.visibility = View.GONE
                binding.mainContent.mainChatIv.visibility = View.VISIBLE
                binding.mainContent.mainDeleteIv.visibility = View.GONE
                binding.mainContent.mainMyFolderIv.visibility = View.VISIBLE
                binding.mainContent.mainBlockIv.visibility = View.GONE
            } else {
                // 선택 모드
                mainRVAdapter.clearSelectedItemList()
                binding.mainContent.mainFolderIv.visibility = View.GONE
                binding.mainContent.mainFolderModeIv.visibility = View.VISIBLE
                binding.mainContent.mainUpdateIv.visibility = View.GONE
                binding.mainContent.mainCancelIv.visibility = View.VISIBLE
                binding.mainContent.mainChatIv.visibility = View.GONE
                binding.mainContent.mainDeleteIv.visibility = View.VISIBLE
                binding.mainContent.mainMyFolderIv.visibility = View.GONE
                binding.mainContent.mainBlockIv.visibility = View.VISIBLE
            }
            // 모든 데이터의 viewType 바꿔주기
            mainRVAdapter.setViewType(currentMode = it)
        })

        binding.mainContent.mainChatListRecyclerView.adapter = mainRVAdapter

        //데이터 추가
        val database = AppDatabase.getInstance(this)!!
        database.chatDao().getRecentChat(getID()).observe(this, {
            Log.d("liveDataAdd", it.toString())
            //Log.d("liveDataAddUseID", getID().toString())
            //Log.d("liveDataAllChat", database.chatDao().getChatList().toString())
            //Log.d("liveDataAllOther",database.otherUserDao().getAllOtherUser(getID()).toString())
            mainRVAdapter.addItem(it)
            chatList.clear()
            chatList.addAll(it)
            binding.mainContent.mainChatListRecyclerView.scrollToPosition(mainRVAdapter.itemCount-1)
        })

        // 취소 버튼 클릭시 다시 초기 화면으로 (폴더 선택 모드 취소)
        binding.mainContent.mainCancelIv.setOnClickListener {
            // 현재 선택 모드 -> 일반 모드로 변경
//            mainRVAdapter.removeSelectedItemList()
            mainRVAdapter.clearSelectedItemList()
            chatViewModel.setMode(mode = 0)

            binding.mainContent.mainFolderIv.visibility = View.VISIBLE
            binding.mainContent.mainFolderModeIv.visibility = View.GONE
            binding.mainContent.mainUpdateIv.visibility = View.VISIBLE
            binding.mainContent.mainCancelIv.visibility = View.GONE
        }
    }

    // 설정 메뉴 창을 띄우는 DrawerLayout 초기화
    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    private fun initDrawerLayout() {
        binding.mainNavigationView.setNavigationItemSelectedListener(this)

        val menuItem = binding.mainNavigationView.menu.findItem(R.id.navi_setting_alarm_item)
        val drawerSwitch =
            menuItem.actionView.findViewById(R.id.main_drawer_alarm_switch) as SwitchCompat

        // 알림 권한 허용 여부에 따라 스위치(토글) 초기 상태 지정
        if (permissionGrantred(this)) {
            // 알림 권한이 허용되어 있는 경우
            drawerSwitch.toggle()
            drawerSwitch.isChecked = true
            permission = true
        } else {
            // 알림 권한이 허용되어 있지 않은 경우
            drawerSwitch.isChecked = false
            permission = false
        }

        drawerSwitch.setOnClickListener {
            if (drawerSwitch.isChecked) {
                // 알림 권한을 허용했을 때 코드를 작성해주시면 됩니다.
                permission = true
                Log.d("toggleListener", "is Checked")
                    startActivity(Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS"))
                    if(permissionGrantred(this)){
                        Toast.makeText(this, "알림 권한을 허용합니다.", Toast.LENGTH_SHORT).show()
                        startForegroundService(Intent(this, MyNotificationListener::class.java))
                    }

            } else {
                permission = false
                Log.d("toggleListener", "is not Checked")
                    startActivity(Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS"))
                    if(!permissionGrantred(this)){
                        stopService(Intent(this, MyNotificationListener::class.java))
                        Toast.makeText(this, "알림 권한을 허용하지 않습니다.", Toast.LENGTH_SHORT).show()
                    }
            }
        }
        // 스위치(토글)를 눌렀을 때, 즉 스위치 체크 상태[방향]가 변했을 때 처리해주는 리스너
    }


    // 설정 메뉴 창의 네비게이션 드로어의 아이템들에 대한 이벤트를 처리
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            // 설정 메뉴창의 아이템(목록)들을 클릭했을 때
            // 알림 설정
            R.id.navi_setting_alarm_item -> {
                Toast.makeText(this, "알림 설정", Toast.LENGTH_SHORT).show()
            }

            // 차단 관리
            R.id.navi_setting_block_item -> {
                Toast.makeText(this, "차단 관리", Toast.LENGTH_SHORT).show()
            }

            // 패턴 변경하기
            R.id.navi_setting_pattern_item -> {
                val lockSPF = getSharedPreferences("lock", 0)
                val pattern = lockSPF.getString("pattern", "0")

                //앱 삭제할때 같이 DB 저장 X
                // 패턴 모드 설정
                // 0: 숨긴 폴더 목록을 확인하기 위한 입력 모드
                // 1: 메인 화면의 설정창 -> 변경 모드
                // 2: 폴더 화면의 설정창 -> 변경 모드
                val modeSPF = getSharedPreferences("mode", 0)
                val editor = modeSPF.edit()
                editor.putInt("mode", 1)
                editor.apply()

                if(pattern.equals("0")) {   // 패턴이 설정되어 있지 않은 경우 패턴 설정 페이지로
                    startNextActivity(CreatePatternActivity::class.java)
                } else {    // 패턴이 설정되어 있는 경우 입력 페이지로 (보안을 위해)
                    startNextActivity(InputPatternActivity::class.java)
                }
            }

            // 공유하기
            R.id.navi_setting_share_item -> {
                Toast.makeText(this, "공유하기", Toast.LENGTH_SHORT).show()
            }

            // 앱 리뷰하기
            R.id.navi_setting_review_item -> {
                Toast.makeText(this, "앱 리뷰하기", Toast.LENGTH_SHORT).show()
            }

            // 이메일 문의
            R.id.navi_setting_email_item -> {
                Toast.makeText(this, "이메일 문의", Toast.LENGTH_SHORT).show()
            }

            // 사용 방법 도움말
            R.id.navi_setting_helper_item -> {
                Toast.makeText(this, "사용 방법 도움말", Toast.LENGTH_SHORT).show()
            }

            // 개인정보 처리방침
            R.id.navi_setting_privacy_item -> {
                Toast.makeText(this, "개인정보 처리방침", Toast.LENGTH_SHORT).show()
            }

            else -> Toast.makeText(this, "잘못된 항목입니다.", Toast.LENGTH_SHORT).show()
        }
        return false
    }

    // 드로어가 나와있을 때 뒤로 가기 버튼을 한 경우 뒤로 가기 버튼에 대한 이벤트를 처리
    override fun onBackPressed() {
        if(binding.mainDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.mainDrawerLayout.closeDrawers()
            Toast.makeText(this, "뒤로 가기", Toast.LENGTH_SHORT).show()
        } else {
            super.onBackPressed()
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun initClickListener() {
        // 내폴더 아이콘 클릭시 폴더 화면으로 이동
        binding.mainContent.mainMyFolderIv.setOnClickListener {
            // startNextActivityWithClear()를 사용하는 게 좋을까?
            startNextActivity(MyFolderActivity::class.java)
            Log.d("toggleListener", "folder")
        }

        // 하단 중앙 아이콘 클릭시
        binding.mainContent.mainFolderIv.setOnClickListener {
            if(chatViewModel.mode.value == 0) {
                chatViewModel.setMode(mode = 1)
            } else {
                chatViewModel.setMode(mode = 0)
            }
        }

        // 폴더 이동 선택 모드 클릭시 팝업 메뉴
        binding.mainContent.mainFolderModeIv.setOnClickListener {
            // 이 부분 띄우는 걸 생략했습니다.
//            popupWindowMainBottomMenu()
            popupWindowToFolderMenu()
        }

        //선택모드 시
        chatViewModel.mode.observe(this,{
            if(it==1)
            {
                //해당 chat 삭제
                binding.mainContent.mainDeleteIv.setOnClickListener {
                    mainRVAdapter.removeSelectedItemList()
                    Toast.makeText(this@MainActivity, "삭제하기", Toast.LENGTH_SHORT).show()
                }
                //해당 chat 차단
                binding.mainContent.mainBlockIv.setOnClickListener {

                }

            }

        }
        )

        // 설정 메뉴창을 여는 메뉴 아이콘 클릭시 설정 메뉴창 열리도록
        binding.mainContent.mainSettingMenuIv.setOnClickListener {
            if(!binding.mainDrawerLayout.isDrawerOpen(GravityCompat.START)) {
                // 설정 메뉴창이 닫혀있을 때
                binding.mainDrawerLayout.openDrawer(GravityCompat.START)
            }
        }

        // 설정 메뉴창에 있는 메뉴 아이콘 클릭시 설정 메뉴창 닫히도록
        val headerView = binding.mainNavigationView.getHeaderView(0)
        headerView.setOnClickListener {
            binding.mainDrawerLayout.closeDrawer(GravityCompat.START)
        }

        binding.mainContent.mainChatIv.setOnClickListener {
            startNextActivity(ChatActivity::class.java)
        }
    }

    // 팝업 메뉴 리스너
    inner class PopupMenuListener: PopupMenu.OnMenuItemClickListener {
        override fun onMenuItemClick(item: MenuItem?): Boolean {
            when(item?.itemId) {
                R.id.popup_menu_1
                        -> {
                    Toast.makeText(this@MainActivity, "삭제하기", Toast.LENGTH_SHORT).show()
                }
                R.id.popup_menu_2
                        -> Toast.makeText(this@MainActivity, "차단하기", Toast.LENGTH_SHORT).show()
                else
                    -> Toast.makeText(this@MainActivity, "잘못된 선택입니다.", Toast.LENGTH_SHORT).show()
            }
            return false
        }
    }

    // 폴더 이동 선택 모드 팝업 메뉴 리스너
    inner class PopupFolderMenuListener: PopupMenu.OnMenuItemClickListener {
        override fun onMenuItemClick(item: MenuItem?): Boolean {
            when(item?.itemId) {
                R.id.popup_folder_menu
                -> {
                    Toast.makeText(this@MainActivity, "폴더로 보내기", Toast.LENGTH_SHORT).show()
                    //1번 더미데이터!
                    //리싸이클러뷰 아이템 누르고 버튼을 누르면 db를 업데이트한다.
                    //리싸이클러뷰 아이템 리스트를 가져와야한다.
                    //어떻게 가져오지..?
                    //인터페이스: main 에서 구현(정의)을 하고 item 별로 그 행동을 하게된다.
                    var chat=ArrayList<Chat>()
                    val rvChatList=mainRVAdapter.chatList
                    val db=AppDatabase.getInstance(this@MainActivity)!!
                    val dao=db.chatDao()
                    val checkedList=mainRVAdapter.selectedItemList as ArrayList<Int>
                    for(i in checkedList){
                        chat.add(dao.getChatByChatIdx(rvChatList[i].chatIdx))
                    }
                    for(i in chat){
                        if(i.groupName==null){
                            db.folderContentDao().insertOtOChat(1, i.otherUserIdx)
                        }
                        else if(i.groupName!=null)
                            db.folderContentDao().insertOrgChat(1, USER_ID, i.groupName!!)
                    }
                    Log.d("folderInsert", db.folderContentDao().getAllfolder().toString())

                }

                else
                -> Toast.makeText(this@MainActivity, "잘못된 선택입니다.", Toast.LENGTH_SHORT).show()
            }
            return false
        }
    }

    inner class VerticalSpaceItemDecoration(private val verticalSpaceHeight: Int): RecyclerView.ItemDecoration() {
        override fun getItemOffsets(
            outRect: Rect,
            view: View,
            parent: RecyclerView,
            state: RecyclerView.State
        ) {
//            super.getItemOffsets(outRect, view, parent, state)
            outRect.bottom = verticalSpaceHeight
        }
    }

    // 이 부분 없애기
    private fun popupWindowMainBottomMenu() {
        val inflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val popupView = inflater.inflate(R.layout.popup_window_main_bottom_menu, null)
        mPopupWindow = PopupWindow(popupView, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT)

        mPopupWindow.animationStyle = -1        // 애니메이션 설정 (-1: 설정 안 함, 0: 설정)
        mPopupWindow.isFocusable = true         // 외부 영역 선택 시 팝업 윈도우 종료
        mPopupWindow.isOutsideTouchable = true
        mPopupWindow.showAtLocation(popupView, Gravity.BOTTOM, 0, 0)

        mPopupWindow.contentView.findViewById<TextView>(R.id.popup_window_main_bottom_menu_to_folder_tv).setOnClickListener {
            // 폴더로 보내기 버튼 눌렀을 때 해당 팝업 윈도우는 사라지고,
            // 보낼 폴더 리스트를 보여주는 팝업 윈도우를 띄운다.
            mPopupWindow.dismiss()
            popupWindowToFolderMenu()
        }
    }

    // 폴더로 보내기 팝업 윈도우
    private fun popupWindowToFolderMenu() {
//        folderList = appDB.folderDao().getFolderByStatus("active") as ArrayList
        folderList = appDB.folderDao().getFolderList() as ArrayList

        // 팝업 윈도우 사이즈를 잘못 맞추면 아이템들이 안 뜨므로 하드 코딩으로 사이즈 조정해주기
        // 아이콘 16개 (기본)
        val size = windowManager.currentWindowMetricsPointCompat()
        val width = (size.x * 0.8f).toInt()
        val height = (size.y * 0.3f).toInt()

        val inflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val popupView = inflater.inflate(R.layout.popup_window_to_folder_menu, null)
        mPopupWindow = PopupWindow(popupView, width, height)

        mPopupWindow.animationStyle = -1        // 애니메이션 설정 (-1: 설정 안 함, 0: 설정)
        mPopupWindow.isFocusable = true         // 외부 영역 선택 시 팝업 윈도우 종료
        mPopupWindow.isOutsideTouchable = true
        mPopupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0)

        // RecyclerView 구분선
        val recyclerView = popupView.findViewById<RecyclerView>(R.id.popup_window_to_folder_menu_recycler_view)
        val dividerItemDecoration =
            DividerItemDecoration(recyclerView.context, DividerItemDecoration.VERTICAL)

        // RecyclerView 초기화
        // 더미 데이터와 어댑터 연결
        val folderListRVAdapter = FolderListRVAdapter(folderList)
        popupView.findViewById<RecyclerView>(R.id.popup_window_to_folder_menu_recycler_view).adapter = folderListRVAdapter
        folderListRVAdapter.setMyItemClickListener(object: FolderListRVAdapter.MyItemClickListener {
            override fun onFolderClick(itemBinding: ItemFolderListBinding, itemPosition: Int) {
                // 폴더 아이콘
                // 폴더로 이동하는 코드 밑에 작성해주시면 됩니다.
                val selectedFolder = folderList[itemPosition]

                if (selectedFolder.status.equals("hidden")) {
                    // 패턴
                    // 0: 입력 모드
                    val modeSPF = getSharedPreferences("mode", 0)
                    val editor = modeSPF.edit()
                    editor.putInt("mode", 3)
                    editor.apply()

                    startNextActivity(InputPatternActivity::class.java)

                    // 폴더로 이동시키는 코드 작성

                }

                // 같이 해도 좋을듯

                Toast.makeText(this@MainActivity, "selected folder: ${selectedFolder.folderName}", Toast.LENGTH_SHORT).show()

                // 팝업 윈도우를 꺼주는 역할
                mPopupWindow.dismiss()
            }
        })
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
}