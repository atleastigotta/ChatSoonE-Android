package com.chat_soon_e.re_chat.ui.ExplainActivity

import com.chat_soon_e.re_chat.ApplicationClass.Companion.mSharedPreferences
import com.chat_soon_e.re_chat.R
import com.chat_soon_e.re_chat.databinding.ActivityExplainBinding
import com.chat_soon_e.re_chat.ui.BaseActivity
import com.chat_soon_e.re_chat.ui.PermissionActivity
import com.chat_soon_e.re_chat.utils.permissionGrantred

class ExplainActivity: BaseActivity<ActivityExplainBinding>(ActivityExplainBinding::inflate) {
    var isExplain=0

    override fun onStart() {
        super.onStart()
        if(getSharedPreferences("explain", MODE_PRIVATE).getInt("explain", 0)==2){
            finish()
        }
    }
    override fun initAfterBinding() {
        initFragment()
        initClick()
    }
    private fun initFragment(){
        supportFragmentManager.beginTransaction()
            .replace(R.id.explain_fl, ExplainFragment())
            .commitAllowingStateLoss()
    }
    private fun initClick(){
        mSharedPreferences=getSharedPreferences("explain", MODE_PRIVATE)
        //x 버튼 클릭시
        binding.explainExitBtnIv.setOnClickListener {
            close()
        }
    }
    override fun onBackPressed() {
        close()
    }
    private fun close(){
        if(binding.explainCheckbox.isChecked){
            isExplain=2
        }else{
            isExplain=1
        }
        val editor= mSharedPreferences.edit()
        editor.putInt("explain", isExplain)
        editor.apply()
        if(!permissionGrantred(this))
            startNextActivity(PermissionActivity::class.java)
        else
            finish()
    }

}