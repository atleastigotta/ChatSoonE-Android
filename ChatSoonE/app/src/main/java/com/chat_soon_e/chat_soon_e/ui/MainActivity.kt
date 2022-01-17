package com.chat_soon_e.chat_soon_e.ui

import android.util.Log
import androidx.recyclerview.widget.DividerItemDecoration
import com.chat_soon_e.chat_soon_e.data.entities.Chat
import com.chat_soon_e.chat_soon_e.data.local.AppDatabase
import com.chat_soon_e.chat_soon_e.databinding.ActivityMainBinding
import com.chat_soon_e.chat_soon_e.ui.BaseActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.content.Intent
import android.view.MenuItem
import android.view.View
import android.widget.PopupMenu
import android.widget.Toast
import androidx.core.app.NotificationManagerCompat
import com.chat_soon_e.chat_soon_e.R

class MainActivity: BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {
    private lateinit var chatDB: AppDatabase            // chat list를 담고 있는 데이터베이스
    private lateinit var mainRVAdapter: MainRVAdapter   // chat list recycler view adpater
    private var chatList = ArrayList<Chat>()            // 데이터베이스로부터 chat list를 받아올 변수

    override fun onStart() {
        super.onStart()
        Log.d("MAIN/LIFE-CYCLE", "onStart()")

        initAlarmStack()
        initChatList()
        initRecyclerView()
        initClickListener()
    }

    override fun initAfterBinding() {
    }

    // NotificationListener 실행
    private fun initAlarmStack() {
        // 권한 허용이 안 되어 있다면 권한 허용을 하는 action을 시작한다.
        if(!permissionGrantred()) {
            val intent = Intent(
                "android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS"
            )
            startActivity(intent)
        }
    }

    // chat list를 불러와 화면의 띄워주는 역할
    // 일단 더미 데이터로 구현
    private fun initChatList() {
        chatDB = AppDatabase.getInstance(this)!!
        chatList = chatDB.chatDao().getChatList() as ArrayList

        // 만약 데이터베이스에서 받아온 chat list가 비어있지 않을 경우
        // 이미 데이터가 있다는 것을 뜻하므로 함수를 리턴한다.
        if(chatList.isNotEmpty()) return

         // 만약 데이터베이스에서 받아온 chat list가 비어있는 경우
         // 더미 데이터
         chatDB.chatDao().insert(Chat(null, "강은서", "Designer", "오전 10시"))
         chatDB.chatDao().insert(Chat(null, "김민경", "PM\nServer(node.js)", "오전 11시"))
         chatDB.chatDao().insert(Chat(null, "남선우", "Android", "오전 12시"))
         chatDB.chatDao().insert(Chat(null, "변재호", "Server (node.js)", "오후 1시"))
         chatDB.chatDao().insert(Chat(null, "이주연", "Android", "오후 2시"))
    }

    private fun initRecyclerView() {
        // RecyclerView 구분선
        val recyclerView = binding.mainChatListRecyclerView
        val dividerItemDecoration =
            DividerItemDecoration(recyclerView.context, DividerItemDecoration.VERTICAL)
        recyclerView.addItemDecoration(dividerItemDecoration)

        // 더미 데이터와 어댑터 연결
        chatDB = AppDatabase.getInstance(this)!!
        chatList = chatDB.chatDao().getChatList() as ArrayList
        mainRVAdapter = MainRVAdapter(chatList)
        binding.mainChatListRecyclerView.adapter = mainRVAdapter

        // 아이템 뷰가 길게 클릭됐을 때 팝업 메뉴 띄우기
        mainRVAdapter.setMyItemClickListener(object: MainRVAdapter.MyItemClickListener {
            override fun onChatLongClick(view: View, position: Int) {
                // 팝업 메뉴 나오도록
                // PopupMenu는 API 11 레벨부터 제공된다.
                Log.d("MAIN/LONG-CLICK", "onChatLongClick")

                // 여기서 view는 클릭된 뷰를 의미한다.
                var popup = PopupMenu(this@MainActivity, view)
                menuInflater.inflate(R.menu.popup_menu, popup.menu)

                // 리스너로 처리
                var listener = PopupMenuListener()
                popup.setOnMenuItemClickListener(listener)
                popup.show()    // 팝업 메뉴 보이도록
            }
        })
    }

    private fun initClickListener() {
        // 내폴더 아이콘을 클릭했을 때 폴더 화면으로 이동할 수 있도록
        binding.mainMyFolderIv.setOnClickListener {
            // startNextActivity(FolderActivity::class.java)
        }

        // 업데이트 버튼을 클릭했을 때 업데이트 해주는 함수 실행
        binding.mainUpdateIv.setOnClickListener {
            update()
        }
    }

    // 알림 스택을 확인하고, 새로 추가된 내용이 있으면 업데이트해주는 함수
    private fun update() {
        initAlarmStack()
    }

    // 권한 체크
    private fun permissionGrantred(): Boolean {
        return NotificationManagerCompat.getEnabledListenerPackages(this).any {
            enabledPackageName -> enabledPackageName == packageName
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
}