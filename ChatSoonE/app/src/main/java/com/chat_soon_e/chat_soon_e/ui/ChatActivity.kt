package com.chat_soon_e.chat_soon_e.ui

import android.util.Log
import android.view.MenuItem
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.PopupMenu
import android.widget.Toast
import com.chat_soon_e.chat_soon_e.R
import com.chat_soon_e.chat_soon_e.databinding.ActivityChatBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ChatActivity: BaseActivity<ActivityChatBinding>(ActivityChatBinding::inflate) {
    private var isFabOpen = false    // FAB(Floating Action Button)가 열렸는지 체크해주는 변수
    private lateinit var fabOpen: Animation
    private lateinit var fabClose: Animation

    override fun initAfterBinding() {
        Log.d("CHAT/LIFE-CYCLE", "onCreate() 이후")
        initFab()
        initClickListener()
    }

    private fun initFab() {
        fabOpen = AnimationUtils.loadAnimation(this, R.anim.fab_open)
        fabClose = AnimationUtils.loadAnimation(this, R.anim.fab_close)
    }

    private fun initClickListener() {
        // 메인 fab 버튼 눌렸을 때
        binding.chatMainFab.setOnClickListener {
            if(isFabOpen) { // fab 버튼이 열려있는 경우
                // 폴더로 보내는 팝업창을 띄운다.
                // 여기서 view는 클릭된 뷰를 의미한다.
                val popup = PopupMenu(this@ChatActivity, binding.chatMainFab)
                menuInflater.inflate(R.menu.popup_folder_menu, popup.menu)

                // 리스너로 처리
                val listener = PopupFolderMenuListener()
                popup.setOnMenuItemClickListener(listener)
                popup.show()    // 팝업 메뉴 보이도록

            } else {    // fab 버튼이 닫혀있는 경우
                binding.chatMainFab.setImageResource(R.drawable.icon_folder_1)
                binding.chatCancelFab.startAnimation(fabOpen)
                binding.chatCancelFab.isClickable = true
                isFabOpen = true
            }
        }

        // 폴더 선택 모드를 해제하기 위해
        binding.chatCancelFab.setOnClickListener {
            binding.chatMainFab.setImageResource(R.drawable.icon_move)
            binding.chatCancelFab.startAnimation(fabClose)
            binding.chatCancelFab.isClickable = false
            isFabOpen = false
        }
    }

    // 폴더 이동 선택 모드 팝업 메뉴 리스너
    inner class PopupFolderMenuListener: PopupMenu.OnMenuItemClickListener {
        override fun onMenuItemClick(item: MenuItem?): Boolean {
            when(item?.itemId) {
                R.id.popup_folder_menu
                -> Toast.makeText(this@ChatActivity, "폴더로 보내기", Toast.LENGTH_SHORT).show()
                else
                -> Toast.makeText(this@ChatActivity, "잘못된 선택입니다.", Toast.LENGTH_SHORT).show()
            }
            return false
        }
    }
}