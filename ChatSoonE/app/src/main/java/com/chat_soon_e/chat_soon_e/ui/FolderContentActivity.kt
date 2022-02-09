package com.chat_soon_e.chat_soon_e.ui

import android.util.Log
import com.chat_soon_e.chat_soon_e.data.entities.Folder
import com.chat_soon_e.chat_soon_e.data.entities.FolderContent
import com.chat_soon_e.chat_soon_e.data.local.AppDatabase
import com.chat_soon_e.chat_soon_e.databinding.ActivityFolderContentBinding
import com.chat_soon_e.chat_soon_e.utils.getID
import com.google.gson.Gson

class FolderContentActivity: BaseActivity<ActivityFolderContentBinding>(ActivityFolderContentBinding::inflate) {
    lateinit var data:FolderContent
    override fun initAfterBinding() {
        initData()
        initRVA()
    }
    //2시간
    //들어간 폴더의 챗 정보를 보여줌??응?
    private fun initData(){
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
    }
    private fun initRVA(){
        // folderIdx 를 가지고 챗들 다 가져와야한다.

    }

}