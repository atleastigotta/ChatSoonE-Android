package com.chat_soon_e.chat_soon_e.ui

import android.util.Log
import com.chat_soon_e.chat_soon_e.databinding.ActivityHiddenFolderBinding

class HiddenFolderActivity: BaseActivity<ActivityHiddenFolderBinding>(ActivityHiddenFolderBinding::inflate) {
    override fun initAfterBinding() {
        Log.d("HIDDENFOLDER/LIFE-CYCLE", "onCreate() 이후")
    }
}