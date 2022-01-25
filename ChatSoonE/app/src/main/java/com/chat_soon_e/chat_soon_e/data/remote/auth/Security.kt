package com.chat_soon_e.chat_soon_e.data.remote.auth

import androidx.security.crypto.MasterKeys

val spec= MasterKeys.AES256_GCM_SPEC
val master= MasterKeys.getOrCreate(spec)