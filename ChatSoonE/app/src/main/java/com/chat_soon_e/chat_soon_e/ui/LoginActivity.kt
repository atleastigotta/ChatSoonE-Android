package com.chat_soon_e.chat_soon_e.ui

import android.view.View
import android.widget.Toast
import com.chat_soon_e.chat_soon_e.data.entities.User
import com.chat_soon_e.chat_soon_e.data.remote.auth.Auth
import com.chat_soon_e.chat_soon_e.data.remote.auth.AuthService
import com.chat_soon_e.chat_soon_e.databinding.ActivityLoginBinding
import com.chat_soon_e.chat_soon_e.utils.saveJwt

class LoginActivity: BaseActivity<ActivityLoginBinding>(ActivityLoginBinding::inflate), LoginView, View.OnClickListener {

    override fun initAfterBinding() {
        binding.loginSignUpTv.setOnClickListener(this)
        binding.loginSignInBtn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if(v == null) return

        when(v) {
            binding.loginSignUpTv -> startNextActivity(SignUpActivity::class.java)
            binding.loginSignInBtn -> login()
        }
    }

    private fun login() {
        if (binding.loginIdEt.text.toString().isEmpty() || binding.loginDirectInputEt.text.toString().isEmpty()) {
            Toast.makeText(this, "이메일을 입력해주세요.", Toast.LENGTH_SHORT).show()
            return
        }

        if (binding.loginPasswordEt.text.toString().isEmpty()) {
            Toast.makeText(this, "비밀번호를 입력해주세요.", Toast.LENGTH_SHORT).show()
            return
        }

        val email = binding.loginIdEt.text.toString() + "@" + binding.loginDirectInputEt.text.toString()
        val password = binding.loginPasswordEt.text.toString()
        val user = User(email, password, "")

        AuthService.login(this, user)
    }

    override fun onLoginLoading() {
        binding.loginLoadingPb.visibility = View.VISIBLE
    }

    override fun onLoginSuccess(auth: Auth) {
        binding.loginLoadingPb.visibility = View.GONE

        saveJwt(auth.jwt)
        startActivityWithClear(MainActivity::class.java)
    }

    override fun onLoginFailure(code: Int, message: String) {
        binding.loginLoadingPb.visibility = View.GONE

        when(code) {
            2015, 2019, 3014 -> {
                binding.loginErrorTv.visibility = View.VISIBLE
                binding.loginErrorTv.text= message
            }
        }
    }
}