package com.chat_soon_e.chat_soon_e.ui

import android.util.Log
import com.chat_soon_e.chat_soon_e.databinding.ActivityFolderBinding

class FolderActivity: BaseActivity<ActivityFolderBinding>(ActivityFolderBinding::inflate) {
    override fun initAfterBinding() {
        Log.d("FOLDER/LIFE-CYCLE", "onCreate() 이후")
    }
}