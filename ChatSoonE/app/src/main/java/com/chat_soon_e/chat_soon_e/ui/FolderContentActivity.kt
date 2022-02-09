package com.chat_soon_e.chat_soon_e.ui

import android.util.Log
import android.widget.PopupMenu
import com.chat_soon_e.chat_soon_e.data.entities.Chat
import com.chat_soon_e.chat_soon_e.data.entities.FolderContent
import com.chat_soon_e.chat_soon_e.data.local.AppDatabase
import com.chat_soon_e.chat_soon_e.databinding.ActivityFolderContentBinding
import com.chat_soon_e.chat_soon_e.utils.getID
import com.google.gson.Gson

class FolderContentActivity: BaseActivity<ActivityFolderContentBinding>(ActivityFolderContentBinding::inflate) {
    private lateinit var database: AppDatabase
    private lateinit var chatList: ArrayList<Chat>
    private lateinit var folderContentRVAdapter: FolderContentRVAdapter
    lateinit var data: FolderContent

    override fun initAfterBinding() {
        initData()
        initRecyclerView()
        initClickListener()
    }
    //들어간 폴더의 챗 정보를 보여줌??응?
    private fun initData(){
        database = AppDatabase.getInstance(this)!!

        // 전 페이지에서 데이터 가져오는 부분
        if(intent.hasExtra("folderData")){
            var folderjson=intent.getStringExtra("folderData")
            var gson=Gson()
            data=gson.fromJson(folderjson, FolderContent::class.java)
            Log.d("folderContentData", data.toString())
            val data=AppDatabase.getInstance(this)!!.folderDao().getFolderChats(getID(), data.folderIdx).observe(
                this, {
                   //= Log.d("folderContentData", it.toString())
                }
            )
        }

        // 폴더 이름으로 바인딩
        binding.folderContentNameTv.text = database.folderDao().getFolderByIdx(data.folderIdx).folderName
    }

    private fun initRecyclerView() {
        database = AppDatabase.getInstance(this)!!
        database.folderDao().getFolderChats(getID(), data.folderIdx).observe(
            this, {
                folderContentRVAdapter.addItem(it)
            })

        folderContentRVAdapter = FolderContentRVAdapter(this, object: FolderContentRVAdapter.MyClickListener {
            override fun onRemoveChat() {
                // 채팅 삭제
                database.folderContentDao().deleteChat(data.folderIdx, data.chatIdx)
            }

            override fun onChatLongClick(popupMenu: PopupMenu) {
                popupMenu.show()
            }
        })

        binding.folderContentRecyclerView.adapter = folderContentRVAdapter
    }

    private fun initClickListener() {
        // 뒤로 가기 버튼 눌렀을 때
        binding.folderContentBackIv.setOnClickListener {
            finish()
        }
    }
}