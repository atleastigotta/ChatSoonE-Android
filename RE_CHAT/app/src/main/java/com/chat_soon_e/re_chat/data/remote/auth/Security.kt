package com.chat_soon_e.re_chat.data.remote.auth

import androidx.security.crypto.MasterKeys

// spf 보안을 위함
val spec = MasterKeys.AES256_GCM_SPEC
val master = MasterKeys.getOrCreate(spec)
// 카카오 유저의 아이디 저장, 추후 spf로 변경
var USER_ID = 0L