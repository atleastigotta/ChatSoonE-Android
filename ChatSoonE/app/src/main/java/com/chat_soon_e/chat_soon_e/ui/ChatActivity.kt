package com.chat_soon_e.chat_soon_e.ui

import android.util.Log
import android.view.MenuItem
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.PopupMenu
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.chat_soon_e.chat_soon_e.R
import com.chat_soon_e.chat_soon_e.data.entities.Chat
import com.chat_soon_e.chat_soon_e.data.entities.TestChat
import com.chat_soon_e.chat_soon_e.data.local.AppDatabase
import com.chat_soon_e.chat_soon_e.databinding.ActivityChatBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ChatActivity: BaseActivity<ActivityChatBinding>(ActivityChatBinding::inflate) {
    private var isFabOpen = false    // FAB(FloatingActionButton)가 열렸는지 체크해주는 변수
    private lateinit var fabOpen: Animation
    private lateinit var fabClose: Animation
    private lateinit var appDB: AppDatabase
    private var chatList = ArrayList<TestChat>()
    private lateinit var chatRVAdapter: ChatRVAdapter
    private val testChatViewModel: TestChatViewModel by viewModels()

    override fun initAfterBinding() {
        initTestChat()
        initFab()
        initRecyclerView()
        initClickListener()
    }

    // test chat 초기화 (테스트용)
    private fun initTestChat() {
        appDB = AppDatabase.getInstance(this)!!
        chatList = appDB.testChatDao().getChatList() as ArrayList

        if(chatList.isNotEmpty()) return

        appDB.testChatDao().insert(TestChat("상대방", "안녕하세요.", null, 0, false))
        appDB.testChatDao().insert(TestChat("상대방", "만나서 반가워", null, 0, false))
        appDB.testChatDao().insert(TestChat("상대방", "잘가", null, 0, false))
        appDB.testChatDao().insert(TestChat("상대방", "또 보자", null, 0, false))
        appDB.testChatDao().insert(TestChat("상대방", "즐거웠어", null, 0, false))
        appDB.testChatDao().insert(TestChat("상대방", "가나다라마바사아자차카타파하", null, 0, false))
        appDB.testChatDao().insert(TestChat("상대방", "ABCDEFGHIJKLMNOPQRSTUVWXYZ", null, 0, false))
        chatList = appDB.testChatDao().getChatList() as ArrayList
    }

    // FAB 애니메이션 초기화
    private fun initFab() {
        fabOpen = AnimationUtils.loadAnimation(this, R.anim.fab_open)
        fabClose = AnimationUtils.loadAnimation(this, R.anim.fab_close)
    }

    // RecyclerView
    private fun initRecyclerView() {
        appDB = AppDatabase.getInstance(this)!!

        chatRVAdapter = ChatRVAdapter(this, object: ChatRVAdapter.MyItemClickListener {
            override fun onRemoveChat(position: Int) {
                appDB.testChatDao().delete(chatList[position])
            }

            override fun onDefaultChatLongClick(popupMenu: PopupMenu) {
                // 채팅 롱클릭 시 팝업 메뉴 뜨도록
                chatRVAdapter.clearSelectedItemList()
                popupMenu.show()
            }

            override fun onChooseChatClick(view: View, position: Int) {
                // 선택 모드
                chatRVAdapter.setChecked(position)
            }
        })

        testChatViewModel.mode.observe(this, {
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

        binding.chatChatRecyclerView.adapter = chatRVAdapter
        chatRVAdapter.addChatList(appDB.testChatDao().getChatList() as ArrayList)

        // 폴더 선택 모드를 해제하기 위해
        binding.chatCancelFab.setOnClickListener {
            binding.chatMainFab.setImageResource(R.drawable.ic_baseline_folder_large_24)
            binding.chatCancelFab.startAnimation(fabClose)
            binding.chatCancelFab.isClickable = false
            isFabOpen = false

            // 일반 모드로
            chatRVAdapter.clearSelectedItemList()
            testChatViewModel.setMode(mode = 0)
        }
   }

    private fun initClickListener() {
        // 메인 FAB 버튼 눌렀을 때
        binding.chatMainFab.setOnClickListener {

            if(testChatViewModel.mode.value == 0) {
                testChatViewModel.setMode(mode = 1)
            } else {
                testChatViewModel.setMode(mode = 0)
            }

            if(isFabOpen) {
                // fab 버튼이 열려있는 경우 (선택 모드에서 클릭했을 때)
                // 폴더로 보내는 팝업창을 띄운다.
                // 여기서 view는 클릭된 뷰를 의미한다.
                val popup = PopupMenu(this@ChatActivity, binding.chatMainFab)
                menuInflater.inflate(R.menu.popup_folder_menu, popup.menu)
                val listener = PopupFolderMenuListener()
                popup.setOnMenuItemClickListener(listener)
                popup.show()
            } else {
                // fab 버튼이 닫혀있는 경우 (일반 모드에서 클릭했을 때)
                binding.chatMainFab.setImageResource(R.drawable.icon_move)
                binding.chatCancelFab.startAnimation(fabOpen)
                binding.chatCancelFab.isClickable = true
                isFabOpen = true
            }
        }

        binding.chatBackIv.setOnClickListener {
            finish()
        }
    }

    // 폴더 이동 선택 모드 팝업 메뉴 리스너
    inner class PopupFolderMenuListener: PopupMenu.OnMenuItemClickListener {
        override fun onMenuItemClick(item: MenuItem?): Boolean {
            when(item?.itemId) {
                R.id.popup_folder_menu
                -> Toast.makeText(this@ChatActivity, "폴더로 보내기", Toast.LENGTH_SHORT).show()
            }
            return false
        }
    }
}