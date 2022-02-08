package com.chat_soon_e.chat_soon_e.ui.ExplainActivity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.widget.ViewPager2
import com.chat_soon_e.chat_soon_e.R
import com.chat_soon_e.chat_soon_e.databinding.FragmentExplainBinding

class ExplainFragment: Fragment(){
    lateinit var binding: FragmentExplainBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentExplainBinding.inflate(inflater, container, false)
        initViewPager()
        return binding.root
    }
    private fun initViewPager(){
        val explainAdapter=ExplainViewpagerAdapter(this)

        //addFragment. 설명 이미지 추가하기
        explainAdapter.addFragment(Explain1Fragment(R.drawable.background))
        explainAdapter.addFragment(Explain1Fragment(R.drawable.background2))
        explainAdapter.addFragment(Explain1Fragment(R.drawable.chatsoon1))

        binding.explainVp.adapter=explainAdapter
        binding.explainVp.orientation=ViewPager2.ORIENTATION_HORIZONTAL
        binding.explainIndicator.setViewPager2(binding.explainVp)

    }



}