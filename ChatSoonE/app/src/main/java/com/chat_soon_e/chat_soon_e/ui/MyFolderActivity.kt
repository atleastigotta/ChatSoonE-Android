package com.chat_soon_e.chat_soon_e.ui

import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.PopupMenu
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.chat_soon_e.chat_soon_e.R
import com.chat_soon_e.chat_soon_e.data.entities.Folder
import com.chat_soon_e.chat_soon_e.data.local.AppDatabase
import com.chat_soon_e.chat_soon_e.databinding.ActivityMyFolderBinding

class MyFolderActivity: BaseActivity<ActivityMyFolderBinding>(ActivityMyFolderBinding::inflate) {
    private lateinit var folderDB: AppDatabase
    private lateinit var folderRVAdapter: MyFolderRVAdapter
    private var folderList = ArrayList<Folder>()

    // onCreate() 이후
    override fun initAfterBinding() {
        // 구현 X
    }

    override fun onStart() {
        super.onStart()
        initFolderList()        // folder list 데이터 초기화
        initRecyclerView()      // RecyclerView Adpater 연결 & 기타 설정
        initClickListener()     // 여러 ClickListener 초기화
    }

    // folder list를 불러와 화면에 띄워주는 역할
    // 일단 더미 데이터로 구현
    private fun initFolderList() {
        folderDB = AppDatabase.getInstance(this)!!
        folderList = folderDB.folderDao().getFolderList() as ArrayList

        // 만약 데이터베이스에서 받아온 folder list가 비어있지 않을 경우
        // 이미 데이터가 있다는 것을 뜻하므로 함수를 리턴한다.
        if(folderList.isNotEmpty()) return

        // 만약 데이터베이스에서 받아온 folder list가 비어있는 경우
        // 더미 데이터
        folderDB.folderDao().insert(Folder(0, "추억"))
        folderDB.folderDao().insert(Folder(1, "여행"))
        folderDB.folderDao().insert(Folder(2, "음식"))
        folderDB.folderDao().insert(Folder(3, "학교"))
        folderDB.folderDao().insert(Folder(4, "게임"))

        Log.d("MYFOLDER/DATA", folderDB.folderDao().getFolderList().toString())
    }

    private fun initRecyclerView() {
        // 더미 데이터와 어댑터 연결
        folderDB = AppDatabase.getInstance(this)!!
        folderList = folderDB.folderDao().getFolderList() as ArrayList
        folderRVAdapter = MyFolderRVAdapter(folderList)
        binding.myFolderFolderListRecyclerView.adapter = folderRVAdapter

//        // 그리드 레이아웃 설정
//        binding.myFolderFolderListRecyclerView.layoutManager = GridLayoutManager(this@MyFolderActivity, 4)

        // 폴더 아이콘 클릭시
        folderRVAdapter.setMyItemClickListener(object: MyFolderRVAdapter.MyItemClickListener {
            // 폴더 아이콘 클릭시 해당 폴더로 이동
            override fun onFolderClick(view: View, position: Int) {
                startNextActivity(FolderActivity::class.java)
            }

            // 폴더 아이콘 롱클릭시 팝업 메뉴 뜨도록
            override fun onFolderLongClick(view: View, position: Int) {
                // 아이콘 클릭시 이름 바꾸기, 아이콘 바꾸기, 삭제하기, 숨기기 목록 표시
                val popup = PopupMenu(this@MyFolderActivity, view)
                menuInflater.inflate(R.menu.popup_folder_edit_menu, popup.menu)

                // 팝업 메뉴 리스너
                val listener = PopupMenuEditListener()
                popup.setOnMenuItemClickListener(listener)
                popup.show()
            }
        })
    }

    private fun initClickListener() {
        binding.myFolderCreateNewFolderIv.setOnClickListener {
            // 아이콘 클릭시 폴더 생성하기, 숨긴 폴더 목록 표시
            val popup = PopupMenu(this@MyFolderActivity, binding.myFolderCreateNewFolderIv)
            menuInflater.inflate(R.menu.popup_folder_option_menu, popup.menu)

            // 팝업 메뉴 리스너
            val listener = PopupFolderMenuOptionListener()
            popup.setOnMenuItemClickListener(listener)
            popup.show()
        }
    }

    inner class PopupFolderMenuOptionListener: PopupMenu.OnMenuItemClickListener {
        override fun onMenuItemClick(item: MenuItem?): Boolean {
            when(item?.itemId) {
                R.id.popup_folder_option_menu_1 -> {
                    Toast.makeText(this@MyFolderActivity, "폴더 생성하기", Toast.LENGTH_SHORT).show()
                }
                R.id.popup_folder_option_menu_2 -> {
                    val sharedPreferences = getSharedPreferences("lock", 0)
                    val pattern = sharedPreferences.getString("pattern", "0")

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

    inner class PopupMenuEditListener: PopupMenu.OnMenuItemClickListener {
        override fun onMenuItemClick(item: MenuItem?): Boolean {
            when(item?.itemId) {
            }
            return false
        }
    }
}