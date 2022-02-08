package com.chat_soon_e.chat_soon_e.ui.ExplainActivity

import android.util.Log
import com.chat_soon_e.chat_soon_e.ApplicationClass.Companion.mSharedPreferences
import com.chat_soon_e.chat_soon_e.R
import com.chat_soon_e.chat_soon_e.databinding.ActivityExplainBinding
import com.chat_soon_e.chat_soon_e.ui.BaseActivity
import com.chat_soon_e.chat_soon_e.ui.PermissionActivity
import com.chat_soon_e.chat_soon_e.utils.permissionGrantred

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