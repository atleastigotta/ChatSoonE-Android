package com.chat_soon_e.chat_soon_e.ui

import android.annotation.SuppressLint
import android.util.Log
import androidx.recyclerview.widget.DividerItemDecoration
import com.chat_soon_e.chat_soon_e.data.entities.Chat
import com.chat_soon_e.chat_soon_e.data.local.AppDatabase
import com.chat_soon_e.chat_soon_e.databinding.ActivityMainBinding
import android.graphics.Rect
import android.os.Build
import android.view.MenuItem
import android.view.View
import android.widget.PopupMenu
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
import com.chat_soon_e.chat_soon_e.R
import com.google.android.material.navigation.NavigationView

class MainActivity: BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate), NavigationView.OnNavigationItemSelectedListener {
//    private lateinit var chatDB: AppDatabase            // chat list를 담고 있는 데이터베이스
    private lateinit var mainRVAdapter: MainRVAdapter   // chat list recycler view adpater
    private var chatList = ArrayList<Chat>()            // 데이터베이스로부터 chat list를 받아올 변수
    private var permission: Boolean = true              // 알림 허용 변수

    // ViewModel
    private val chatViewModel: ChatViewModel by viewModels()

    // onCreate() 이후
    override fun initAfterBinding() {
        Log.d("MAIN/LIFE-CYCLE", "after onCreate()")
        initChatList()              // chat list 데이터 초기화
    }

    // initAfterBinding() 이후 실행
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onStart() {
        super.onStart()
        Log.d("MAIN/LIFE-CYCLE", "onStart()")

        //initNotificationListener()  // NotificationListener (알림 권한 허용)
        //initChatList()              // chat list 데이터 초기화
        initRecyclerView()          // RecylcerView Adapter 연결 & 기타 설정
        initDrawerLayout()          // 설정 메뉴창 설정
        initClickListener()         // 여러 ClickListener 초기화
    }
    // 권한 체크
    private fun permissionGrantred(): Boolean {
        return NotificationManagerCompat.getEnabledListenerPackages(this).any {
                enabledPackageName -> enabledPackageName == packageName
        }
    }

    // chat list를 불러와 화면의 띄워주는 역할
    private fun initChatList() {
        if(chatList.isNotEmpty()) return

        val database = AppDatabase.getInstance(this)!!
        val chatDB = database.chatDao().getRecentChat(USER_ID)
        chatList.addAll(chatDB)
        Log.d("DBCHECK", chatDB.toString())

        // 만약 데이터베이스에서 받아온 chat list가 비어있지 않을 경우
        // 이미 데이터가 있다는 것을 뜻하므로 함수를 리턴한다.
        // 만약 데이터베이스에서 받아온 chat list가 비어있는 경우
//        chatDB.chatDao().insert(Chat("강은서", "designer"))
//        chatDB.chatDao().insert(Chat("김민경", "node.js"))
//        chatDB.chatDao().insert(Chat("남선우", "android"))
//        chatDB.chatDao().insert(Chat("변재호", "node.js"))
//        chatDB.chatDao().insert(Chat("이주연", "android"))
//        chatDB.chatDao().insert(Chat("UMC", "android & server"))
//        chatDB.chatDao().insert(Chat("친구1", "안녕?"))
//        chatDB.chatDao().insert(Chat("친구2", "Hello."))
//        chatDB.chatDao().insert(Chat("친구3", "봉쥬르"))
//        chatDB.chatDao().insert(Chat("친구4", "반가워"))
//        chatDB.chatDao().insert(Chat("친구5", "Hi!"))
//        chatDB.chatDao().insert(Chat("그룹1", "이모티콘"))
//        chatDB.chatDao().insert(Chat("그룹2", "이모티콘"))
//        chatDB.chatDao().insert(Chat("그룹3", "이모티콘"))
    }

    // RecyclerView
    private fun initRecyclerView() {
        val database = AppDatabase.getInstance(this)!!
        val chatDB=database.chatDao().getRecentChat(USER_ID)
        chatList.addAll(chatDB)

        // RecyclerView 구분선
        val recyclerView = binding.mainContent.mainChatListRecyclerView
        val dividerItemDecoration =
            DividerItemDecoration(recyclerView.context, DividerItemDecoration.VERTICAL)
        recyclerView.addItemDecoration(dividerItemDecoration)

        // RecyclerView Click Listener
        mainRVAdapter = MainRVAdapter(chatList, this, object: MainRVAdapter.MyItemClickListener {
            // 선택 모드
            override fun onChooseChatClick(view: View, position: Int) {
                mainRVAdapter.setChecked(position)
            }

            // 이동 모드
            override fun onDefaultChatClick(view: View, position: Int) {
                startNextActivity(ChatActivity::class.java)
                mainRVAdapter.clearSelectedItemList()
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
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    private fun initDrawerLayout() {
        binding.mainNavigationView.setNavigationItemSelectedListener(this)

        val menuItem = binding.mainNavigationView.menu.findItem(R.id.navi_setting_alarm_item)
        val drawerSwitch = menuItem.actionView.findViewById(R.id.main_drawer_alarm_switch) as SwitchCompat

        // 알림 권한 허용 여부에 따라 스위치(토글) 초기 상태 지정
        if(permissionGrantred()) {
            // 알림 권한이 허용되어 있는 경우
            drawerSwitch.toggle()
            drawerSwitch.isChecked = true
            permission = true
        } else {
            // 알림 권한이 허용되어 있지 않은 경우
            drawerSwitch.isChecked = false
            permission = false
        }

        // 스위치(토글)를 눌렀을 때, 즉 스위치 체크 상태[방향]가 변했을 때 처리해주는 리스너
        drawerSwitch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                // 알림 권한을 허용했을 때 코드를 작성해주시면 됩니다.
                Toast.makeText(this, "알림 권한을 허용합니다.", Toast.LENGTH_SHORT).show()
                permission = true
            } else {
                // 알림 권한을 허용하지 않았을 때 코드를 작성해주시면 됩니다.
                Toast.makeText(this, "알림 권한을 허용하지 않습니다.", Toast.LENGTH_SHORT).show()
                permission = false
            }
        }
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
            // 팝업 메뉴 나오도록
            // PopupMenu는 API 11 레벨부터 제공된다.
            Log.d("MAIN/POPUP", "폴더 이동 선택 모드 팝업 메뉴")

            // 여기서 view는 클릭된 뷰를 의미한다.
            val popup = PopupMenu(this@MainActivity, binding.mainContent.mainFolderModeIv)
            menuInflater.inflate(R.menu.popup_folder_menu, popup.menu)

            // 리스너로 처리
            val listener = PopupFolderMenuListener()
            popup.setOnMenuItemClickListener(listener)
            popup.show()    // 팝업 메뉴 보이도록
        }

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
    }

    // 팝업 메뉴 리스너
    inner class PopupMenuListener: PopupMenu.OnMenuItemClickListener {
        override fun onMenuItemClick(item: MenuItem?): Boolean {
            when(item?.itemId) {
                R.id.popup_menu_1
                        -> Toast.makeText(this@MainActivity, "삭제하기", Toast.LENGTH_SHORT).show()
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
                -> Toast.makeText(this@MainActivity, "폴더로 보내기", Toast.LENGTH_SHORT).show()
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
}