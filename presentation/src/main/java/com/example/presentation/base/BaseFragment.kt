package com.example.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.example.presentation.BR
import com.example.presentation.util.bindView
import com.example.presentation.util.showKeyboard

abstract class BaseFragment<B :ViewDataBinding, VM : ViewModel> : Fragment() {
    lateinit var binding: B
    protected abstract val mViewModel: VM

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = bindView()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.setVariable(BR.viewModel, mViewModel)
    }

    override fun onPause() {
        super.onPause()
        closeKeyboard()
    }

    private fun closeKeyboard(){
        showKeyboard(false)
    }

    fun openKeyboard(){
        showKeyboard(true)
    }
}