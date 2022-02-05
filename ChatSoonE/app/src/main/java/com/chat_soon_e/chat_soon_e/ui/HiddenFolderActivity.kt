package com.chat_soon_e.chat_soon_e.ui

import android.annotation.SuppressLint
import android.graphics.Insets
import android.graphics.Point
import android.util.Log
import android.view.*
import android.widget.EditText
import android.widget.PopupMenu
import android.widget.PopupWindow
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.RecyclerView
import com.chat_soon_e.chat_soon_e.R
import com.chat_soon_e.chat_soon_e.data.entities.Folder
import com.chat_soon_e.chat_soon_e.data.entities.Icon
import com.chat_soon_e.chat_soon_e.data.local.AppDatabase
import com.chat_soon_e.chat_soon_e.databinding.ActivityHiddenFolderBinding
import com.chat_soon_e.chat_soon_e.databinding.ItemHiddenFolderBinding
import com.chat_soon_e.chat_soon_e.databinding.ItemIconBinding
import com.chat_soon_e.chat_soon_e.databinding.ItemMyFolderBinding

class HiddenFolderActivity: BaseActivity<ActivityHiddenFolderBinding>(ActivityHiddenFolderBinding::inflate) {
    private lateinit var appDB: AppDatabase
    private lateinit var hiddenFolderRVAdapter: HiddenFolderRVAdapter
    private lateinit var iconRVAdapter: ChangeIconRVAdapter
    private var folderList = ArrayList<Folder>()
    private var iconList = ArrayList<Icon>()
    private lateinit var mPopupWindow: PopupWindow

    // Popupwindow와 RecyclerView 연결을 위해 선언
    private lateinit var itemBinding: ItemHiddenFolderBinding
    private var itemPosition: Int = 0

    override fun initAfterBinding() {
        initFolder()            // 폴더 초기화
        initIcon()              // 아이콘 초기화
        initClickListener()     // 여러 click listener 초기화
    }

    private fun initFolder() {
        appDB = AppDatabase.getInstance(this)!!
        folderList = appDB.folderDao().getFolderList() as ArrayList

        // RecyclerView 초기화
        hiddenFolderRVAdapter = HiddenFolderRVAdapter(this)
        binding.hiddenFolderListRecyclerView.adapter = hiddenFolderRVAdapter

        hiddenFolderRVAdapter.setMyItemClickListener(object: HiddenFolderRVAdapter.MyItemClickListener {
            override fun onRemoveFolder(idx: Int) {
                appDB.folderDao().updateStatusByIdx("delete", idx)
            }

            override fun onShowFolder(idx: Int) {
                appDB.folderDao().updateStatusByIdx("active", idx)
            }

            override fun onFolderNameLongClick(binding: ItemHiddenFolderBinding, position: Int) {
                itemBinding = binding
                changeFolderName(itemBinding)
            }

            override fun onFolderClick(view: View, position: Int) {
                startNextActivity(FolderActivity::class.java)
            }

            override fun onFolderLongClick(popup: PopupMenu) {
                popup.show()
            }
        })
        hiddenFolderRVAdapter.addFolderList(appDB.folderDao().getFolderByStatus("hidden") as ArrayList)
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

    private fun initClickListener() {
        // 내폴더 아이콘 눌렀을 때
        binding.hiddenFolderMyFolderIv.setOnClickListener {
            startActivityWithClear(MyFolderActivity::class.java)
            finish()
        }
    }

    // 이름 바꾸기 팝업 윈도우를 띄워서 폴더 이름을 변경할 수 있도록 해준다.
    @SuppressLint("InflateParams")
    fun changeFolderName(binding: ItemHiddenFolderBinding) {
        // 이름 바꾸기 팝업 윈도우
        val inflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val popupView = inflater.inflate(R.layout.popup_window_change_name, null)
        mPopupWindow = PopupWindow(popupView, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT)

        mPopupWindow.animationStyle = -1        // 애니메이션 설정 (-1: 설정 안 함, 0: 설정)
        mPopupWindow.isFocusable = true         // 외부 영역 선택 시 팝업 윈도우 종료
        mPopupWindow.isOutsideTouchable = true
        mPopupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0)

        // 기존 폴더 이름을 팝업 윈도우의 EditText에 넘겨준다.
        var text: String = binding.itemHiddenFolderTv.text.toString()
        mPopupWindow.contentView.findViewById<EditText>(R.id.popup_window_change_name_et).setText(text)

        // RoomDB
        appDB = AppDatabase.getInstance(this@HiddenFolderActivity)!!
        val folder = appDB.folderDao().getFolderByName(text)

        // 입력 완료했을 때 누르는 버튼
        mPopupWindow.contentView.findViewById<AppCompatButton>(R.id.popup_window_change_name_button).setOnClickListener {
            text = mPopupWindow.contentView.findViewById<EditText>(R.id.popup_window_change_name_et).text.toString()
            binding.itemHiddenFolderTv.text = text

            folder.folderName = text
            appDB.folderDao().update(folder)

            // 팝업 윈도우 종료
            mPopupWindow.dismiss()
        }
        hiddenFolderRVAdapter.addFolderList(appDB.folderDao().getFolderByStatus("hidden") as ArrayList)
    }

    @SuppressLint("InflateParams")
    fun changeIcon(binding: ItemHiddenFolderBinding, position: Int, folderListFromAdapter: ArrayList<Folder>) {
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
                binding.itemHiddenFolderIv.setImageResource(selectedIcon.iconImage)

                appDB = AppDatabase.getInstance(this@HiddenFolderActivity)!!

                // RoomDB 적용
                val folder = appDB.folderDao().getFolderByIdx(folderListFromAdapter[position].idx)
                appDB.folderDao().updateFolderImgByIdx(selectedIcon.iconImage, folder.idx)
                folderList = appDB.folderDao().getFolderList() as ArrayList
                hiddenFolderRVAdapter.addFolderList(appDB.folderDao().getFolderByStatus("hidden") as ArrayList)

                // 팝업 윈도우 종료
                mPopupWindow.dismiss()
            }
        })
//        folderRVAdapter.addFolderList(appDB.folderDao().getFolderByStatus("active") as ArrayList)
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