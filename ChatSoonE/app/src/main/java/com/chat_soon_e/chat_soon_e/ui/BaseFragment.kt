package com.chat_soon_e.chat_soon_e.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.chat_soon_e.chat_soon_e.utils.Inflate

// 전체적으로 뷰 바인딩을 하고, initAfterBinding() 해주는 흐름은 BaseActivity와 똑같다고 보면 된다.
abstract class BaseFragment<VB : ViewBinding>(
    private val inflate: Inflate<VB>
) : Fragment() {
    private var _binding: VB? = null
    // protected val binding get() = _binding!!
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflate.invoke(inflater, container, false)

        return binding.root
    }

    override fun onStart() {
        super.onStart()
        initAfterBinding()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null // 바인딩을 풀어주는 역할
    }

    protected abstract fun initAfterBinding()

    fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }
}