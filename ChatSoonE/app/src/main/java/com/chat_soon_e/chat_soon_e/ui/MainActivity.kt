package com.chat_soon_e.chat_soon_e.ui

import android.util.Log
import androidx.recyclerview.widget.DividerItemDecoration
import com.chat_soon_e.chat_soon_e.data.entities.Chat
import com.chat_soon_e.chat_soon_e.data.local.AppDatabase
import com.chat_soon_e.chat_soon_e.databinding.ActivityMainBinding
import android.content.Intent
import android.graphics.Color
import android.graphics.Rect
import android.view.MenuItem
import android.view.View
import android.widget.PopupMenu
import android.widget.Toast
import androidx.core.app.NotificationManagerCompat
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.RecyclerView
import com.chat_soon_e.chat_soon_e.R
import com.google.android.material.navigation.NavigationView

class MainActivity: BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate), NavigationView.OnNavigationItemSelectedListener {
//    private lateinit var contentBinding: ActivityMainBinding
    private lateinit var chatDB: AppDatabase            // chat list를 담고 있는 데이터베이스
    private lateinit var mainRVAdapter: MainRVAdapter   // chat list recycler view adpater
    private var chatList = ArrayList<Chat>()            // 데이터베이스로부터 chat list를 받아올 변수
    private var isSelectionMode: Boolean = false        // 폴더 이동 선택 모드인지 아닌지를 결정해주는 변수

    // onCreate() 이후
    override fun initAfterBinding() {

    }

    // initAfterBinding() 이후 실행
    override fun onStart() {
        super.onStart()
        Log.d("MAIN/LIFE-CYCLE", "onStart()")

        initNotificationListener()  // NotificationListener (알림 권한 허용)
        initChatList()              // chat list 데이터 초기화
        initRecyclerView()          // RecylcerView Adapter 연결 & 기타 설정
        initDrawerLayout()          // 설정 메뉴창 설정
        initClickListener()         // 여러 ClickListener 초기화
    }

    // NotificationListener 실행
    private fun initNotificationListener() {
        // 권한 허용이 안 되어 있다면 권한 허용을 하는 action을 시작한다.
        if(!permissionGrantred()) {
            val intent = Intent(
                "android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS"
            )
            startActivity(intent)
        }
    }

    // 권한 체크
    private fun permissionGrantred(): Boolean {
        return NotificationManagerCompat.getEnabledListenerPackages(this).any {
                enabledPackageName -> enabledPackageName == packageName
        }
    }

    // chat list를 불러와 화면에 띄워주는 역할
    // 일단 더미 데이터로 구현
    private fun initChatList() {
        chatDB = AppDatabase.getInstance(this)!!
        chatList = chatDB.chatDao().getChatList() as ArrayList

        // 만약 데이터베이스에서 받아온 chat list가 비어있지 않을 경우
        // 이미 데이터가 있다는 것을 뜻하므로 함수를 리턴한다.
        if(chatList.isNotEmpty()) return

//        // 만약 데이터베이스에서 받아온 chat list가 비어있는 경우
//        // 더미 데이터
//        chatDB.chatDao().insert(Chat(null, "강은서", "Designer", "오전 10시"))
//        chatDB.chatDao().insert(Chat(null, "김민경", "PM\nServer(node.js)", "오전 11시"))
//        chatDB.chatDao().insert(Chat(null, "남선우", "Android", "오전 12시"))
//        chatDB.chatDao().insert(Chat(null, "변재호", "Server (node.js)", "오후 1시"))
//        chatDB.chatDao().insert(Chat(null, "이주연", "Android", "오후 2시"))
//        chatDB.chatDao().insert(Chat(null, "강은서", "Designer", "오후 3시"))
//        chatDB.chatDao().insert(Chat(null, "김민경", "PM\nServer(node.js)", "오후 4시"))
//        chatDB.chatDao().insert(Chat(null, "남선우", "Android", "오후 5시"))
//        chatDB.chatDao().insert(Chat(null, "변재호", "Server (node.js)", "오후 6시"))
//        chatDB.chatDao().insert(Chat(null, "이주연", "Android", "오후 7시"))

        Log.d("MAIN/DATA", chatDB.chatDao().getChatList().toString())
    }

    // RecyclerView
    private fun initRecyclerView() {
//        val binding = ActivityMainContentBinding.inflate(layoutInflater)

        // RecyclerView 구분선
        val recyclerView = binding.mainContent.mainChatListRecyclerView
        val dividerItemDecoration =
            DividerItemDecoration(recyclerView.context, DividerItemDecoration.VERTICAL)
        recyclerView.addItemDecoration(dividerItemDecoration)

//        // 간격 설정
//        val layoutParams = binding.mainContent.mainChatListRecyclerView.layoutParams
//        layoutParams.height = 500
//        binding.mainContent.mainChatListRecyclerView.requestLayout()
//
//        val spaceDecoration = VerticalSpaceItemDecoration(200)
//        recyclerView.addItemDecoration(spaceDecoration)

        // 더미 데이터와 어댑터 연결
        chatDB = AppDatabase.getInstance(this)!!
        chatList = chatDB.chatDao().getChatList() as ArrayList
        mainRVAdapter = MainRVAdapter(chatList, isSelectionMode)
        binding.mainContent.mainChatListRecyclerView.adapter = mainRVAdapter

        // '취소하기' 클릭시
        binding.mainContent.mainModeCancelTv.setOnClickListener {
            mainRVAdapter.clearSelectedItemList()
            setBottomByMode(true)
        }

        // 취소 버튼 클릭시 다시 초기 화면으로 (폴더 선택 모드 취소)
        binding.mainContent.mainCancelIv.setOnClickListener {
            mainRVAdapter.clearSelectedItemList()
            setBottomByMode(true)

            binding.mainContent.mainFolderIv.visibility = View.VISIBLE
            binding.mainContent.mainFolderModeIv.visibility = View.GONE
            binding.mainContent.mainUpdateIv.visibility = View.VISIBLE
            binding.mainContent.mainCancelIv.visibility = View.GONE
        }

        mainRVAdapter.setMyItemClickListener(object: MainRVAdapter.MyItemClickListener {
            override fun onChatClick(view: View, position: Int) {
                Log.d("MAIN/RV", "onChatClick()")
//                mainRVAdapter.toggleItemSelected(position)
            }

            override fun onChatLongClick(view: View, position: Int) {
                Log.d("MAIN/RV", "onChatLongClick()")
                if(isSelectionMode) return
                setBottomByMode(false)
//                mainRVAdapter.toggleItemSelected(position)
//                // 팝업 메뉴 나오도록
//                // PopupMenu는 API 11 레벨부터 제공된다.
//                Log.d("MAIN/LONG-CLICK", "onChatLongClick")
//
//                // 여기서 view는 클릭된 뷰를 의미한다.
//                val popup = PopupMenu(this@MainActivity, view)
//                menuInflater.inflate(R.menu.popup_menu, popup.menu)
//
//                // 리스너로 처리
//                val listener = PopupMenuListener()
//                popup.setOnMenuItemClickListener(listener)
//                popup.show()    // 팝업 메뉴 보이도록
            }

            override fun onChatClickForFolder(view: View, position: Int) {
                Log.d("MAIN/RV", "onChatClickForFolder()")
//                mainRVAdapter.toggleItemSelected(position)
                if(!isSelectionMode) return
                setBottomByMode(true)
            }

        })

//        if(isSelectionMode) {   // 만약 폴더 이동 선택 모드일 경우
//            mainRVAdapter.setMyItemClickListener(object: MainRVAdapter.MyItemClickListener {
//                override fun onChatClick(view: View, position: Int) {
//                    Log.d("MAIN/RV", "onChatClick()")
//                }
//
//                override fun onChatLongClick(view: View, position: Int) {
//                    Log.d("MAIN/RV", "onChatLongClick()")
//                }
//
//            })
//        } else {    // 만약 폴더 이동 선택 모드가 아닐 경우
//            // 아이템 뷰가 길게 클릭됐을 때 팝업 메뉴 띄우기
//            mainRVAdapter.setMyItemClickListener(object: MainRVAdapter.MyItemClickListener {
//                override fun onChatClick(view: View, position: Int) {
//                    // 대화 목록으로 이동하는 코드 작성
//                    // 논의 필요
//                }
//
//                override fun onChatLongClick(view: View, position: Int) {
//                    // 팝업 메뉴 나오도록
//                    // PopupMenu는 API 11 레벨부터 제공된다.
//                    Log.d("MAIN/LONG-CLICK", "onChatLongClick")
//
//                    // 여기서 view는 클릭된 뷰를 의미한다.
//                    val popup = PopupMenu(this@MainActivity, view)
//                    menuInflater.inflate(R.menu.popup_menu, popup.menu)
//
//                    // 리스너로 처리
//                    val listener = PopupMenuListener()
//                    popup.setOnMenuItemClickListener(listener)
//                    popup.show()    // 팝업 메뉴 보이도록
//                }
//
//            })
//        }
    }

    // 설정 메뉴 창을 띄우는 DrawerLayout 초기화
    private fun initDrawerLayout() {
//        드로어를 꺼낼 홈버튼 활성화
//        supportActionBar?.setDisplayHomeAsUpEnabled(true)
//        홈버튼 이미지 변경
//        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_baseline_menu_24)

        binding.mainNavigationView.setNavigationItemSelectedListener(this)

        // 설정 메뉴창에서 알림 권한 허용 여부 표시해주기 위해
        if(!permissionGrantred()) {
            // 허용이 되어 있지 않다면
            binding.mainNavigationView.menu.getItem(0).setActionView(R.layout.activity_main_drawer_toggle_off)
        } else {
            // 허용이 되어 있다면
            binding.mainNavigationView.menu.getItem(0).setActionView(R.layout.activity_main_drawer_toggle_on)
        }
    }

//    툴바 메뉴 버튼이 클릭되었을 때 실행된다.
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        when(item.itemId) { // 메뉴 버튼
//            android.R.id.home ->
//                binding.mainDrawerLayout.openDrawer(GravityCompat.START)
//        }
//        return super.onOptionsItemSelected(item)
//    }

    // 설정 메뉴 창의 네비게이션 드로어의 아이템들에 대한 이벤트를 처리
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
//            R.id.main_drawer_alarm_toggle_on_layout -> {
//                binding.mainNavigationView.menu.getItem(0).setActionView(R.layout.activity_main_drawer_toggle_off)
//                Toast.makeText(this, "알림 권한을 허용하지 않습니다.", Toast.LENGTH_SHORT).show()
//
//                // 알림 허용을 꺼주는 코드 추가하기 (권한 해제)
//            }
//
//            R.id.main_drawer_alarm_toggle_off_layout -> {
//                binding.mainNavigationView.menu.getItem(0).setActionView(R.layout.activity_main_drawer_toggle_on)
//                Toast.makeText(this, "알림 권한을 허용합니다.", Toast.LENGTH_SHORT).show()
//
//                // 알림 허용을 해주는 코드 추가하기 (권한 부여)
//            }

            // 설정 메뉴창의 아이템(목록)들을 클릭했을 때
            // 알림 설정
            R.id.navi_setting_alarm_item -> {
                Toast.makeText(this, "알림 설정", Toast.LENGTH_SHORT).show()
            }

            // 차단 관리
            R.id.navi_setting_block_item -> {
                Toast.makeText(this, "차단 관리", Toast.LENGTH_SHORT).show()
            }

            // 이메일 문의
            R.id.navi_setting_email_item -> {
                Toast.makeText(this, "이메일 문의", Toast.LENGTH_SHORT).show()
            }

            // 사용 방법 도움말
            R.id.navi_setting_helper_item -> {
                Toast.makeText(this, "사용 방법 도움말", Toast.LENGTH_SHORT).show()
            }

            // 앱 리뷰하기
            R.id.navi_setting_review_item -> {
                Toast.makeText(this, "앱 리뷰하기", Toast.LENGTH_SHORT).show()
            }

            // 공유하기
            R.id.navi_setting_share_item -> {
                Toast.makeText(this, "공유하기", Toast.LENGTH_SHORT).show()
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

    private fun setBottomByMode(isSelectionMode: Boolean) {
        // 폴더 이동 선택 모드 아닐 때
        if(!isSelectionMode) {
            binding.mainContent.mainBottomBarView.setBackgroundColor(Color.parseColor("#FED7D3"))
            binding.mainContent.mainMyFolderIv.visibility = View.GONE
            binding.mainContent.mainFolderIv.visibility = View.GONE
            binding.mainContent.mainChatIv.visibility = View.GONE
            binding.mainContent.mainModeBottomLayout.visibility = View.VISIBLE
        } else {    // 폴더 이동 선택 모드일 때
            binding.mainContent.mainBottomBarView.setBackgroundColor(Color.parseColor("#BFBFBF"))
            binding.mainContent.mainMyFolderIv.visibility = View.VISIBLE
            binding.mainContent.mainFolderIv.visibility = View.VISIBLE
            binding.mainContent.mainChatIv.visibility = View.VISIBLE
            binding.mainContent.mainModeBottomLayout.visibility = View.GONE
        }
    }

    private fun initClickListener() {
        // 내폴더 아이콘 클릭시 폴더 화면으로 이동
        binding.mainContent.mainMyFolderIv.setOnClickListener {
            // startNextActivityWithClear()를 사용하는 게 좋을까?
            startNextActivity(MyFolderActivity::class.java)
        }

        // (특정 폴더로 옮길 특정 채팅을 선택하는 모드로 들어가게 해주는) 폴더 아이콘 클릭시
        binding.mainContent.mainFolderIv.setOnClickListener {
            binding.mainContent.mainFolderIv.visibility = View.GONE
            binding.mainContent.mainFolderModeIv.visibility = View.VISIBLE
            binding.mainContent.mainUpdateIv.visibility = View.GONE
            binding.mainContent.mainCancelIv.visibility = View.VISIBLE

            // RecyclerView의 아이템 클릭이벤트를 실행시킬 수 있도록
            // 폴더 이동 선택 모드 설정
            isSelectionMode = true
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

//        // 취소 버튼 클릭시 다시 초기 화면으로 (폴더 선택 모드 취소)
//        binding.mainContent.mainCancelIv.setOnClickListener {
//            binding.mainContent.mainFolderIv.visibility = View.VISIBLE
//            binding.mainContent.mainFolderModeIv.visibility = View.GONE
//            binding.mainContent.mainUpdateIv.visibility = View.VISIBLE
//            binding.mainContent.mainCancelIv.visibility = View.GONE
//        }

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

//        binding.mainNavigationView.menu.getItem(0).actionView.setOnClickListener {
//            if(!permissionGrantred()) { // 허용이 안 되어 있는 경우
//                // 허용이 안 된 (toggle off) 상태에서 허용된 (toggle on) 상태로 바꿔주고, 그에 맞춰 뷰 바인딩을 해준다.
//                binding.mainNavigationView.menu.getItem(0).setActionView(R.layout.activity_main_drawer_toggle_on)
//            } else {    // 허용이 되어있는 겨웅
//                binding.mainNavigationView.menu.getItem(0).setActionView(R.layout.activity_main_drawer_toggle_off)
//            }
//        }

//        업데이트 버튼을 클릭했을 때 업데이트 해주는 함수 실행
//        binding.mainUpdateIv.setOnClickListener {
//            update()
//        }
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