package com.chat_soon_e.chat_soon_e.ui

import android.util.Log
import com.chat_soon_e.chat_soon_e.data.entities.Folder
import com.chat_soon_e.chat_soon_e.data.entities.FolderContent
import com.chat_soon_e.chat_soon_e.databinding.ActivityFolderContentBinding
import com.google.gson.Gson

class FolderContentActivity: BaseActivity<ActivityFolderContentBinding>(ActivityFolderContentBinding::inflate) {
    lateinit var data:FolderContent
    override fun initAfterBinding() {
        initData()
    }
    //들어간 폴더의 챗 정보를 보여줌??응?
    private fun initData(){
        if(intent.hasExtra("folderData")){
            var folderjson=intent.getStringExtra("folderData")
            var gson=Gson()
            data=gson.fromJson(folderjson, FolderContent::class.java)
            Log.d("folderContentData", data.toString())
        }
    }

}