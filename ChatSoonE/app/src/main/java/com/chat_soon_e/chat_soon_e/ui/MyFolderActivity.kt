package com.chat_soon_e.chat_soon_e.ui

import android.annotation.SuppressLint
import android.content.Intent
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
import com.chat_soon_e.chat_soon_e.ApplicationClass.Companion.ACTIVE
import com.chat_soon_e.chat_soon_e.ApplicationClass.Companion.DELETED
import com.chat_soon_e.chat_soon_e.ApplicationClass.Companion.HIDDEN
import com.chat_soon_e.chat_soon_e.data.entities.Icon
import com.chat_soon_e.chat_soon_e.databinding.ItemIconBinding
import android.view.MotionEvent

import android.view.View.OnTouchListener
import com.google.gson.Gson


class MyFolderActivity: BaseActivity<ActivityMyFolderBinding>(ActivityMyFolderBinding::inflate), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var database: AppDatabase
    private lateinit var folderRVAdapter: MyFolderRVAdapter
    private lateinit var iconRVAdapter: ChangeIconRVAdapter
    private var folderList = ArrayList<Folder>()
    private var iconList = ArrayList<Icon>()
    private lateinit var mPopupWindow: PopupWindow

    // Popupwindow와 RecyclerView 연결을 위해 선언
    private lateinit var itemBinding: ItemMyFolderBinding

    override fun initAfterBinding() {
        database = AppDatabase.getInstance(this)!!
        iconList = database.iconDao().getIconList() as ArrayList   // 아이콘 받아오기
        initRecyclerView()          // 폴더 초기화
        initDrawerLayout()          // 설정 메뉴창 설정
        initClickListener()         // 여러 click listener 초기화
    }

    // RecyclerView
    private fun initRecyclerView() {
        folderList = database.folderDao().getFolderList() as ArrayList

        // RecyclerView 초기화
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
                var folder=folderRVAdapter.getSelectedFolder(position)

                Log.d("FolderContentss", folder.toString())
                // folder삽입시 status변경!null아님!!!!!!!!
                val gson=Gson()
                var folderJson=gson.toJson(folder)

                // 폴더 정보를 보내기기
               var intent=Intent(this@MyFolderActivity, FolderContentActivity::class.java)
                intent.putExtra("folderData", folderJson)
                startActivity(intent)
            }

            // 폴더 아이콘 롱클릭 시 팝업 메뉴 뜨도록
            override fun onFolderLongClick(popup: PopupMenu) {
                popup.show()
            }

            // 폴더 삭제하기
            override fun onRemoveFolder(idx: Int) {
                database.folderDao().updateStatusByIdx(DELETED, idx)
            }

            // 폴더 숨기기
            override fun onHideFolder(idx: Int) {
                // 여기서 index를 어떻게 바꿔야 할까?
                // 숨김 폴더 인덱스를 맨 뒤로 넣는 식으로 해서 폴더 리스트 순서를 바꿔줘야 한다. (데이터베이스 안에)
                database.folderDao().updateStatusByIdx(HIDDEN, idx)
                val hiddenFolder = database.folderDao().getFolderByIdx(idx)
                database.folderDao().delete(hiddenFolder.idx)
                database.folderDao().insert(hiddenFolder)
            }
        })

        // RecyclerView와 데이터 연결
        folderRVAdapter.addFolderList(database.folderDao().getFolderByStatus(ACTIVE) as ArrayList)
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
                // 3: 메인 화면 폴더 리스트에서 숨김 폴더 클릭 시
                val modeSPF = getSharedPreferences("mode", 0)
                val editor = modeSPF.edit()

                // 여기서는 2번 모드
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
        } else {
            super.onBackPressed()
            startActivityWithClear(MainActivity::class.java)
            finish()
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

    // 이름 바꾸기 팝업 윈도우를 띄워서 폴더 이름을 변경할 수 있도록 해준다.
    @SuppressLint("InflateParams", "ClickableViewAccessibility")
    fun changeFolderName(itemBinding: ItemMyFolderBinding) {
        // 이름 바꾸기 팝업 윈도우
        val inflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val popupView = inflater.inflate(R.layout.popup_window_change_name, null)
        mPopupWindow = PopupWindow(popupView, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT)

        mPopupWindow.animationStyle = -1        // 애니메이션 설정 (-1: 설정 안 함, 0: 설정)
        mPopupWindow.isFocusable = true         // 외부 영역 선택 시 팝업 윈도우 종료
        mPopupWindow.isOutsideTouchable = true
        mPopupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0)
        binding.myFolderContent.myFolderBackgroundView.visibility = View.VISIBLE    // 뒷배경 흐려지게
        mPopupWindow.setOnDismissListener(PopupWindowDismissListener())
        // 기존 폴더 이름을 팝업 윈도우의 EditText에 넘겨준다.
        var text: String = itemBinding.itemMyFolderTv.text.toString()
        mPopupWindow.contentView.findViewById<EditText>(R.id.popup_window_change_name_et).setText(text)

        // RoomDB
        database = AppDatabase.getInstance(this@MyFolderActivity)!!
        val folder = database.folderDao().getFolderByName(text)
        // 입력 완료했을 때 누르는 버튼
        mPopupWindow.contentView.findViewById<AppCompatButton>(R.id.popup_window_change_name_button).setOnClickListener {
            text = mPopupWindow.contentView.findViewById<EditText>(R.id.popup_window_change_name_et).text.toString()
            itemBinding.itemMyFolderTv.text = text

            folder.folderName = text
            database.folderDao().update(folder)
            database.folderDao().update(folder)

            // 팝업 윈도우 종료
            mPopupWindow.dismiss()

            // 뒷배경 원래대로
            binding.myFolderContent.myFolderBackgroundView.visibility = View.INVISIBLE
        }
        folderRVAdapter.addFolderList(database.folderDao().getFolderByStatus(ACTIVE) as ArrayList)
    }

    @SuppressLint("InflateParams", "ClickableViewAccessibility")
    fun changeIcon(binding: ItemMyFolderBinding, position: Int, folderListFromAdapter: ArrayList<Folder>) {
        // 팝업 윈도우 사이즈를 잘못 맞추면 아이템들이 안 뜨므로 하드 코딩으로 사이즈 조정해주기
        // 아이콘 16개 (기본)
        val size = windowManager.currentWindowMetricsPointCompat()
        val width = (size.x * 0.8f).toInt()
        val height = (size.y * 0.6f).toInt()

        // 아이콘 바꾸기 팝업 윈도우
        val inflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val popupView = inflater.inflate(R.layout.popup_window_change_icon, null)
        mPopupWindow = PopupWindow(popupView, width, height)

        mPopupWindow.animationStyle = -1        // 애니메이션 설정 (-1: 설정 안 함, 0: 설정)
        mPopupWindow.isFocusable = true
        mPopupWindow.isOutsideTouchable = true

        mPopupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0)
        mPopupWindow.setOnDismissListener(PopupWindowDismissListener())

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

                database = AppDatabase.getInstance(this@MyFolderActivity)!!

                // RoomDB 적용
                val folder = database.folderDao().getFolderByIdx(folderListFromAdapter[position].idx)
                database.folderDao().updateFolderImgByIdx(selectedIcon.iconImage, folder.idx)
                folderList = database.folderDao().getFolderList() as ArrayList
                folderRVAdapter.addFolderList(database.folderDao().getFolderByStatus(ACTIVE) as ArrayList)

                // 팝업 윈도우 종료
                mPopupWindow.dismiss()
            }
        })
        folderRVAdapter.addFolderList(database.folderDao().getFolderByStatus(ACTIVE) as ArrayList)
    }

    // 가운데 아래 버튼 클릭 시 나오는 팝업 메뉴
    @SuppressLint("InflateParams")
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
            // 3: 메인 화면 폴더 리스트에서 숨김 폴더 클릭 시
            val modeSPF = getSharedPreferences("mode", 0)
            val editor = modeSPF.edit()

            // 여기서는 0번 모드
            editor.putInt("mode", 0)
            editor.apply()

            if(pattern.equals("0")) {   // 패턴이 설정되어 있지 않은 경우 패턴 설정 페이지로
                Toast.makeText(this@MyFolderActivity, "패턴이 설정되어 있지 않습니다.\n패턴을 설정해주세요.", Toast.LENGTH_SHORT).show()
                startNextActivity(CreatePatternActivity::class.java)
            } else {
                startNextActivity(InputPatternActivity::class.java)
            }
        }
    }

    // 새폴더 이름 설정
    @SuppressLint("InflateParams")
    private fun setFolderName() {
        val inflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val popupView = inflater.inflate(R.layout.popup_window_set_folder_name, null)
        mPopupWindow = PopupWindow(popupView, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT)

        mPopupWindow.animationStyle = -1        // 애니메이션 설정 (-1: 설정 안 함, 0: 설정)
        mPopupWindow.isFocusable = true         // 외부 영역 선택 시 팝업 윈도우 종료
        mPopupWindow.isOutsideTouchable = true
        mPopupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0)
        mPopupWindow.setOnDismissListener(PopupWindowDismissListener())

        // 입력 완료했을 때 누르는 버튼
        mPopupWindow.contentView.findViewById<AppCompatButton>(R.id.popup_window_set_name_button).setOnClickListener {
            // 작성한 폴더 이름을 반영한 새폴더를 만들어준다.
            val name = mPopupWindow.contentView.findViewById<EditText>(R.id.popup_window_set_name_et).text.toString()

            // 팝업 윈도우 종료
            mPopupWindow.dismiss()

            // 작성한 폴더 이름을 setFolderIcon 함수로 넘겨준다.
            setFolderIcon(name)
        }
        folderRVAdapter.addFolderList(database.folderDao().getFolderByStatus(ACTIVE) as ArrayList)
    }

    // 새폴더 아이콘 설정
    @SuppressLint("InflateParams")
    private fun setFolderIcon(name: String) {
        // 팝업 윈도우 사이즈를 잘못 맞추면 아이템들이 안 뜨므로 하드 코딩으로 사이즈 조정해주기
        // 아이콘 16개 (기본)
        val size = windowManager.currentWindowMetricsPointCompat()
        val width = (size.x * 0.8f).toInt()
        val height = (size.y * 0.6f).toInt()

        // 아이콘 바꾸기 팝업 윈도우
        val inflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val popupView = inflater.inflate(R.layout.popup_window_change_icon, null)
        mPopupWindow = PopupWindow(popupView, width, height)

        mPopupWindow.animationStyle = -1        // 애니메이션 설정 (-1: 설정 안 함, 0: 설정)
        mPopupWindow.isFocusable = true
        mPopupWindow.isOutsideTouchable = true
        mPopupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0)
        mPopupWindow.setOnDismissListener(PopupWindowDismissListener())

        // RecyclerView 초기화
        iconRVAdapter = ChangeIconRVAdapter(iconList)
        popupView.findViewById<RecyclerView>(R.id.popup_window_change_icon_recycler_view).adapter = iconRVAdapter

        iconRVAdapter.setMyItemClickListener(object: ChangeIconRVAdapter.MyItemClickListener {
            // 아이콘을 하나 선택했을 경우
            override fun onIconClick(itemBinding: ItemIconBinding, itemPosition: Int) {
                val selectedIcon = iconList[itemPosition]
                val lastIdx = folderList.size

                // 선택한 아이콘과 전달받은 폴더 이름으로 폴더 하나 생성한 후 RoomDB에 적용
                val newFolder = Folder(lastIdx, 0, null, name, selectedIcon.iconImage, ACTIVE)
                database = AppDatabase.getInstance(this@MyFolderActivity)!!
                database.folderDao().insert(newFolder)
                folderList = database.folderDao().getFolderList() as ArrayList
                folderRVAdapter.addFolderList(database.folderDao().getFolderByStatus(ACTIVE) as ArrayList)

                // 팝업 윈도우 종료
                mPopupWindow.dismiss()
            }
        })
    }

    // 디바이스 크기에 사이즈를 맞추기 위한 함수
    private fun WindowManager.currentWindowMetricsPointCompat(): Point {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
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
            binding.myFolderContent.myFolderBackgroundView.visibility = View.INVISIBLE
        }
    }
}