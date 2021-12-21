package com.example.presentation.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.domain.usecase.Status
import com.example.presentation.base.BaseFragment
import com.example.presentation.databinding.FragmentMoviesBinding
import com.example.presentation.model.MovieItem
import com.example.presentation.util.gone
import com.example.presentation.util.observe
import com.example.presentation.util.visible
import org.koin.android.viewmodel.ext.android.viewModel

class MoviesFragment : BaseFragment<FragmentMoviesBinding, MoviesViewModel>() {

    override val mViewModel: MoviesViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mViewModel.apply {

            observe(mutableLiveData) {
                when (it) {
                    is MovieItem -> {
                        // TODO:: navigate to movie details fragment
                    }
                }
            }
            observe(resultLiveData) {
                when (it?.status) {
                    Status.SUCCESS -> {
                        binding.progressBar.gone()
                    }
                    Status.ERROR -> {
                        binding.progressBar.gone()
                        Toast.makeText(context,it.message,Toast.LENGTH_LONG).show()
                    }
                    Status.LOADING -> {
                        binding.progressBar.visible()
                    }
                    Status.EMPTY -> {
                        binding.progressBar.gone()
                        binding.tvEmptyView.visible()
                    }
                }
            }
        }

    }

}