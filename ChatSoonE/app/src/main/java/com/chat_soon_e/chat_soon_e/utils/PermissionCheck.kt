package com.chat_soon_e.chat_soon_e.utils

import android.content.Context
import androidx.core.app.NotificationManagerCompat
import com.chat_soon_e.chat_soon_e.ApplicationClass

fun permissionGrantred(context:Context): Boolean {
    return NotificationManagerCompat.getEnabledListenerPackages(context).any {
            enabledPackageName -> enabledPackageName == context.packageName
    }
}