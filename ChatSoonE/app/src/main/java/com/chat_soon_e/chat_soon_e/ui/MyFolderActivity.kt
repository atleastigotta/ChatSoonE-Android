package com.chat_soon_e.chat_soon_e.ui

import android.annotation.SuppressLint
import android.graphics.Insets
import android.graphics.Point
import android.os.Build
import android.util.Log
import android.view.*
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.SwitchCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.view.GravityCompat
import com.chat_soon_e.chat_soon_e.R
import com.chat_soon_e.chat_soon_e.data.entities.Folder
import com.chat_soon_e.chat_soon_e.data.local.AppDatabase
import com.chat_soon_e.chat_soon_e.databinding.ActivityMyFolderBinding
import com.chat_soon_e.chat_soon_e.databinding.ItemMyFolderBinding
import com.google.android.material.navigation.NavigationView
import androidx.recyclerview.widget.RecyclerView
import com.chat_soon_e.chat_soon_e.data.entities.Icon
import com.chat_soon_e.chat_soon_e.databinding.ItemIconBinding

class MyFolderActivity: BaseActivity<ActivityMyFolderBinding>(ActivityMyFolderBinding::inflate), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var appDB: AppDatabase
    private lateinit var folderRVAdapter: MyFolderRVAdapter
    private lateinit var iconRVAdapter: ChangeIconRVAdapter
    private var folderList = ArrayList<Folder>()
    private var iconList = ArrayList<Icon>()
    private lateinit var mPopupWindow: PopupWindow

    // Popupwindow와 RecyclerView 연결을 위해 선언
    private lateinit var itemBinding: ItemMyFolderBinding
    private var itemPosition: Int = 0

    // onCreate() 이후
    override fun initAfterBinding() {
        initFolder()                // 폴더 초기화
        initIcon()                  // 아이콘 초기화
        initDrawerLayout()          // 설정 메뉴창 설정
        initClickListener()         // 여러 click listener 초기화
    }

    // 폴더 초기화
    private fun initFolder() {
        appDB = AppDatabase.getInstance(this)!!
        folderList = appDB.folderDao().getFolderList() as ArrayList

        // 만약 데이터베이스에서 받아온 folder list가 비어있는 경우
        // 더미 데이터
        if(folderList.isEmpty()) {
            appDB.folderDao().insert(Folder(0, 0, null, "추억", R.drawable.ic_baseline_folder_24, "active"))
            appDB.folderDao().insert(Folder(1, 0, null, "여행", R.drawable.ic_baseline_folder_24, "active"))
            appDB.folderDao().insert(Folder(2, 0, null, "음식", R.drawable.ic_baseline_folder_24, "active"))
            appDB.folderDao().insert(Folder(3, 0, null, "학교", R.drawable.ic_baseline_folder_24, "active"))
            appDB.folderDao().insert(Folder(4, 0, null, "게임", R.drawable.ic_baseline_folder_24, "active"))
            folderList = appDB.folderDao().getFolderList() as ArrayList
        }

        // RecyclerView 초기화
        // 더미 데이터와 어댑터 연결
        folderRVAdapter = MyFolderRVAdapter(this)
        binding.myFolderContent.myFolderFolderListRecyclerView.adapter = folderRVAdapter

        // click listener
        folderRVAdapter.setMyItemClickListener(object: MyFolderRVAdapter.MyItemClickListener {
            // 폴더 이름 롱클릭 시 폴더 이름 변경
            @RequiresApi(Build.VERSION_CODES.O)
            override fun onFolderNameLongClick(binding: ItemMyFolderBinding, position: Int) {
                itemBinding = binding
                changeFolderName(itemBinding)
            }

            // 폴더 아이콘 클릭 시 해당 폴더로 이동
            override fun onFolderClick(view: View, position: Int) {
                startNextActivity(FolderActivity::class.java)
            }

            // 폴더 아이콘 롱클릭 시 팝업 메뉴 뜨도록
            override fun onFolderLongClick(popup: PopupMenu) {
                popup.show()
            }

            // 폴더 삭제하기
            override fun onRemoveFolder(idx: Int) {
                appDB.folderDao().updateStatusByIdx("delete", idx)
            }

            // 폴더 숨기기
            override fun onHideFolder(idx: Int) {
                appDB.folderDao().updateStatusByIdx("hidden", idx)
            }
        })
        folderRVAdapter.addFolderList(appDB.folderDao().getFolderByStatus("active") as ArrayList)
    }

    private fun initIcon() {
        appDB = AppDatabase.getInstance(this)!!
        iconList = appDB.iconDao().getIconList() as ArrayList

        // 더미 데이터
        // 이 부분은 서버와 통신하지 않고 자체적으로 구현
        if(iconList.isEmpty()) {
            appDB.iconDao().insert(Icon(R.drawable.ic_baseline_insert_emoticon_24))
            appDB.iconDao().insert(Icon(R.drawable.ic_baseline_cancel_24))
            appDB.iconDao().insert(Icon(R.drawable.ic_baseline_folder_24))
            appDB.iconDao().insert(Icon(R.drawable.ic_baseline_account_circle_24))
            appDB.iconDao().insert(Icon(R.drawable.ic_baseline_cached_24))
            appDB.iconDao().insert(Icon(R.drawable.ic_baseline_check_box_24))
            iconList = appDB.iconDao().getIconList() as ArrayList
        }
    }

    // 설정 메뉴 창을 띄우는 DrawerLayout 초기화
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    private fun initDrawerLayout() {
        binding.myFolderNavigationView.setNavigationItemSelectedListener(this)

        val menuItem = binding.myFolderNavigationView.menu.findItem(R.id.navi_setting_alarm_item)
        val drawerSwitch = menuItem.actionView.findViewById(R.id.main_drawer_alarm_switch) as SwitchCompat

        // 알림 권한 허용 여부에 따라 스위치(토글) 초기 상태 지정
        if(permissionGrantred()) {
            // 알림 권한이 허용되어 있는 경우
            drawerSwitch.toggle()
            drawerSwitch.isChecked = true
        } else {
            // 알림 권한이 허용되어 있지 않은 경우
            drawerSwitch.isChecked = false
        }

        // 스위치(토글)를 눌렀을 때, 즉 스위치 체크 상태[방향]가 변했을 때 처리해주는 리스너
        drawerSwitch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                // 알림 권한을 허용했을 때 코드를 작성해주시면 됩니다.
                Toast.makeText(this, "알림 권한을 허용합니다.", Toast.LENGTH_SHORT).show()
            } else {
                // 알림 권한을 허용하지 않았을 때 코드를 작성해주시면 됩니다.
                Toast.makeText(this, "알림 권한을 허용하지 않습니다.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // 권한 체크
    private fun permissionGrantred(): Boolean {
        return NotificationManagerCompat.getEnabledListenerPackages(this).any {
                enabledPackageName -> enabledPackageName == packageName
        }
    }

    // 설정 메뉴 창의 네비게이션 드로어의 아이템들에 대한 이벤트를 처리
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
                editor.putInt("mode", 2)
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
        if(binding.myFolderDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.myFolderDrawerLayout.closeDrawers()
            Toast.makeText(this, "뒤로 가기", Toast.LENGTH_SHORT).show()
        } else {
            super.onBackPressed()
        }
    }

    // click listener
    private fun initClickListener() {
        // 설정 메뉴창을 여는 메뉴 아이콘 클릭시 설정 메뉴창 열리도록
        binding.myFolderContent.myFolderMenuIv.setOnClickListener {
            if(!binding.myFolderDrawerLayout.isDrawerOpen(GravityCompat.START)) {
                // 설정 메뉴창이 닫혀있을 때
                binding.myFolderDrawerLayout.openDrawer(GravityCompat.START)
            }
        }

        // 하단 중앙의 버튼을 눌렀을 때
        binding.myFolderContent.myFolderCreateNewFolderIv.setOnClickListener {
            popupFolderBottomMenu()
        }

        // 설정 메뉴창에 있는 메뉴 아이콘 클릭시 설정 메뉴창 닫히도록
        val headerView = binding.myFolderNavigationView.getHeaderView(0)
        headerView.setOnClickListener {
            binding.myFolderDrawerLayout.closeDrawer(GravityCompat.START)
        }
    }

    // 폴더 팝업 메뉴
    inner class PopupFolderMenuOptionListener: PopupMenu.OnMenuItemClickListener {
        override fun onMenuItemClick(item: MenuItem?): Boolean {
            when(item?.itemId) {
                R.id.popup_folder_option_menu_1 -> {
                    // 폴더 생성하기
                    Toast.makeText(this@MyFolderActivity, "폴더 생성하기", Toast.LENGTH_SHORT).show()
                }
                R.id.popup_folder_option_menu_2 -> {
                    // 숨긴 폴더 목록 보기
                    val lockSPF = getSharedPreferences("lock", 0)
                    val pattern = lockSPF.getString("pattern", "0")

                    // 패턴 모드 설정
                    // 0: 숨긴 폴더 목록을 확인하기 위한 입력 모드
                    // 1: 메인 화면의 설정창 -> 변경 모드
                    // 2: 폴더 화면의 설정창 -> 변경 모드
                    val modeSPF = getSharedPreferences("mode", 0)
                    val editor = modeSPF.edit()
                    editor.putInt("mode", 0)
                    editor.apply()

                    if(pattern.equals("0")) {   // 패턴이 설정되어 있지 않은 경우 패턴 설정 페이지로
                        Toast.makeText(this@MyFolderActivity, "패턴이 설정되어 있지 않습니다. 패턴을 설정해주세요.", Toast.LENGTH_SHORT).show()
                        startNextActivity(CreatePatternActivity::class.java)
                    } else {
                        startNextActivity(InputPatternActivity::class.java)
                    }
                }
            }
            return false
        }
    }

    // 이름 바꾸기 팝업 윈도우를 띄워서 폴더 이름을 변경할 수 있도록 해준다.
    @SuppressLint("InflateParams")
    fun changeFolderName(binding: ItemMyFolderBinding) {
        // 이름 바꾸기 팝업 윈도우
        val inflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val popupView = inflater.inflate(R.layout.popup_window_change_name, null)
        mPopupWindow = PopupWindow(popupView, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT)

        mPopupWindow.animationStyle = -1        // 애니메이션 설정 (-1: 설정 안 함, 0: 설정)
        mPopupWindow.isFocusable = true         // 외부 영역 선택 시 팝업 윈도우 종료
        mPopupWindow.isOutsideTouchable = true
        mPopupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0)

        // 기존 폴더 이름을 팝업 윈도우의 EditText에 넘겨준다.
        var text: String = binding.itemMyFolderTv.text.toString()
        mPopupWindow.contentView.findViewById<EditText>(R.id.popup_window_change_name_et).setText(text)

        // RoomDB
        appDB = AppDatabase.getInstance(this@MyFolderActivity)!!
        val folder = appDB.folderDao().getFolderByName(text)

        // 입력 완료했을 때 누르는 버튼
        mPopupWindow.contentView.findViewById<AppCompatButton>(R.id.popup_window_change_name_button).setOnClickListener {
            text = mPopupWindow.contentView.findViewById<EditText>(R.id.popup_window_change_name_et).text.toString()
            binding.itemMyFolderTv.text = text

            folder.folderName = text
            appDB.folderDao().update(folder)

            // 팝업 윈도우 종료
            mPopupWindow.dismiss()
        }
        folderRVAdapter.addFolderList(appDB.folderDao().getFolderByStatus("active") as ArrayList)
    }

    @SuppressLint("InflateParams")
    fun changeIcon(binding: ItemMyFolderBinding, position: Int, folderListFromAdapter: ArrayList<Folder>) {
        // 팝업 윈도우 사이즈를 잘못 맞추면 아이템들이 안 뜨므로 하드 코딩으로 사이즈 조정해주기
        // 아이콘 16개 (기본)
        val size = windowManager.currentWindowMetricsPointCompat()
        val width = (size.x * 0.8f).toInt()
        val height = (size.y * 0.3f).toInt()

        // 아이콘 바꾸기 팝업 윈도우
        val inflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val popupView = inflater.inflate(R.layout.popup_window_change_icon, null)
        mPopupWindow = PopupWindow(popupView, width, height)

        mPopupWindow.animationStyle = -1        // 애니메이션 설정 (-1: 설정 안 함, 0: 설정)
        mPopupWindow.isFocusable = true
        mPopupWindow.isOutsideTouchable = true
        mPopupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0)

        // RecyclerView 초기화
        // 더미 데이터와 어댑터 연결
        iconRVAdapter = ChangeIconRVAdapter(iconList)
        popupView.findViewById<RecyclerView>(R.id.popup_window_change_icon_recycler_view).adapter = iconRVAdapter

        iconRVAdapter.setMyItemClickListener(object: ChangeIconRVAdapter.MyItemClickListener {
            // 아이콘을 하나 선택했을 경우
            override fun onIconClick(itemBinding: ItemIconBinding, itemPosition: Int) {
                // 선택한 아이콘으로 폴더 이미지 변경
                val selectedIcon = iconList[itemPosition]
                binding.itemMyFolderIv.setImageResource(selectedIcon.iconImage)

                appDB = AppDatabase.getInstance(this@MyFolderActivity)!!

                // RoomDB 적용
                val folder = appDB.folderDao().getFolderByIdx(folderListFromAdapter[position].idx)
                appDB.folderDao().updateFolderImgByIdx(selectedIcon.iconImage, folder.idx)
                folderList = appDB.folderDao().getFolderList() as ArrayList
                folderRVAdapter.addFolderList(appDB.folderDao().getFolderByStatus("active") as ArrayList)

                Log.d("MY-FOLDER", "selectedIcon: $selectedIcon")
                Log.d("MY-FOLDER", "position: $position")
                Log.d("MY-FOLDER", "itemPosition: $itemPosition")
                Log.d("MY-FOLDER", "folderImg: ${appDB.folderDao().getFolderByIdx(folder.idx)}")

                // 팝업 윈도우 종료
                mPopupWindow.dismiss()
            }
        })
//        folderRVAdapter.addFolderList(appDB.folderDao().getFolderByStatus("active") as ArrayList)
    }

    private fun popupFolderBottomMenu() {
        val inflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val popupView = inflater.inflate(R.layout.popup_window_folder_bottom_menu, null)
        mPopupWindow = PopupWindow(popupView, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT)

        mPopupWindow.animationStyle = -1        // 애니메이션 설정 (-1: 설정 안 함, 0: 설정)
        mPopupWindow.isFocusable = true         // 외부 영역 선택 시 팝업 윈도우 종료
        mPopupWindow.isOutsideTouchable = true
        mPopupWindow.showAtLocation(popupView, Gravity.BOTTOM, 0, 0)

        // 폴더 생성하기 클릭
        mPopupWindow.contentView.findViewById<TextView>(R.id.popup_window_folder_bottom_menu_create_folder_tv).setOnClickListener {
            // 폴더 이름을 입력하라는 윈도우 띄우기
            // 그 다음 폴더 아이콘을 선택하라는 윈도우 띄우기
            // 리사이클러뷰 & RoomDB에 반영해주기
            mPopupWindow.dismiss()
            setFolderName()
        }

        // 숨긴 폴더 목록 클릭
        mPopupWindow.contentView.findViewById<TextView>(R.id.popup_window_folder_bottom_menu_hidden_folder_tv).setOnClickListener {
            mPopupWindow.dismiss()

            // 숨긴 폴더 목록 보기
            val lockSPF = getSharedPreferences("lock", 0)
            val pattern = lockSPF.getString("pattern", "0")

            // 패턴 모드 설정
            // 0: 숨긴 폴더 목록을 확인하기 위한 입력 모드
            // 1: 메인 화면의 설정창 -> 변경 모드
            // 2: 폴더 화면의 설정창 -> 변경 모드
            val modeSPF = getSharedPreferences("mode", 0)
            val editor = modeSPF.edit()
            editor.putInt("mode", 0)
            editor.apply()

            if(pattern.equals("0")) {   // 패턴이 설정되어 있지 않은 경우 패턴 설정 페이지로
                Toast.makeText(this@MyFolderActivity, "패턴이 설정되어 있지 않습니다. 패턴을 설정해주세요.", Toast.LENGTH_SHORT).show()
                startNextActivity(CreatePatternActivity::class.java)
            } else {
                startNextActivity(InputPatternActivity::class.java)
            }
        }
    }

    private fun setFolderName() {
        // 이름 바꾸기 팝업 윈도우
        val inflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val popupView = inflater.inflate(R.layout.popup_window_set_folder_name, null)
        mPopupWindow = PopupWindow(popupView, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT)

        mPopupWindow.animationStyle = -1        // 애니메이션 설정 (-1: 설정 안 함, 0: 설정)
        mPopupWindow.isFocusable = true         // 외부 영역 선택 시 팝업 윈도우 종료
        mPopupWindow.isOutsideTouchable = true
        mPopupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0)

        // 입력 완료했을 때 누르는 버튼
        mPopupWindow.contentView.findViewById<AppCompatButton>(R.id.popup_window_set_name_button).setOnClickListener {
            // 작성한 폴더 이름을 반영한 새폴더를 만들어준다.
            val name = mPopupWindow.contentView.findViewById<EditText>(R.id.popup_window_set_name_et).text.toString()

            // 팝업 윈도우 종료
            mPopupWindow.dismiss()

            // 작성한 폴더 이름을 setFolderIcon 함수로 넘겨준다.
            setFolderIcon(name)
        }
//        folderRVAdapter.addFolderList(appDB.folderDao().getFolderByStatus("active") as ArrayList)
    }

    private fun setFolderIcon(name: String) {
        // 팝업 윈도우 사이즈를 잘못 맞추면 아이템들이 안 뜨므로 하드 코딩으로 사이즈 조정해주기
        // 아이콘 16개 (기본)
        val size = windowManager.currentWindowMetricsPointCompat()
        val width = (size.x * 0.8f).toInt()
        val height = (size.y * 0.3f).toInt()

        // 아이콘 바꾸기 팝업 윈도우
        val inflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val popupView = inflater.inflate(R.layout.popup_window_change_icon, null)
        mPopupWindow = PopupWindow(popupView, width, height)

        mPopupWindow.animationStyle = -1        // 애니메이션 설정 (-1: 설정 안 함, 0: 설정)
        mPopupWindow.isFocusable = true
        mPopupWindow.isOutsideTouchable = true
        mPopupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0)

        // RecyclerView 초기화
        // 더미 데이터와 어댑터 연결
        iconRVAdapter = ChangeIconRVAdapter(iconList)
        popupView.findViewById<RecyclerView>(R.id.popup_window_change_icon_recycler_view).adapter = iconRVAdapter

        iconRVAdapter.setMyItemClickListener(object: ChangeIconRVAdapter.MyItemClickListener {
            // 아이콘을 하나 선택했을 경우
            override fun onIconClick(itemBinding: ItemIconBinding, itemPosition: Int) {
                val selectedIcon = iconList[itemPosition]
                val lastIdx = folderList.size

                Log.d("MY-FOLDER", "folder list size: ${folderList.size}")

                // 선택한 아이콘과 전달받은 폴더 이름으로 폴더 하나 생성한 후 RoomDB에 적용
                val newFolder = Folder(lastIdx, 0, null, name, selectedIcon.iconImage, "active")
                appDB = AppDatabase.getInstance(this@MyFolderActivity)!!
                appDB.folderDao().insert(newFolder)
                folderList = appDB.folderDao().getFolderList() as ArrayList
                Log.d("MY-FOLDER", "folder list size: ${folderList.size}")
                folderRVAdapter.addFolderList(appDB.folderDao().getFolderByStatus("active") as ArrayList)

                // 팝업 윈도우 종료
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