package com.chat_soon_e.re_chat.ui.ExplainActivity

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class ExplainViewpagerAdapter(Fragment:Fragment):FragmentStateAdapter(Fragment) {

    private val fragmentlist:ArrayList<Fragment> = ArrayList()

    override fun getItemCount(): Int = fragmentlist.size

    override fun createFragment(position: Int): Fragment =fragmentlist[position]

    fun addFragment(fragment: Fragment){
        //외부에서 직접 리스트를 접근하지 못하기 때문에 함수를 사용함(set)
        fragmentlist.add(fragment)
        notifyItemInserted(fragmentlist.size-1);//추가된 곳의 인덱스를 뷰페이저에게 알려주는 함수
    }


}