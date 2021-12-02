package com.example.presentation.ui.fragment.movie

import android.os.Bundle
import android.view.View
import com.example.presentation.base.BaseFragment
import com.example.presentation.databinding.FragmentMoviesBinding
import com.example.presentation.model.MovieItem
import com.example.presentation.util.Status
import com.example.presentation.util.observe
import org.koin.android.viewmodel.ext.android.viewModel

class MoviesFragment : BaseFragment<FragmentMoviesBinding,MoviesViewModel>() {

    override val mViewModel: MoviesViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mViewModel.apply {

            observe(mutableLiveData) {
                when (it) {
                    is MovieItem -> {}
                }
            }
            observe(resultLiveData) {
                when (it?.status) {
                    Status.SUCCESS -> {

                    }
                    Status.MESSAGE -> {

                    }
                    Status.LOADING -> {

                    }
                }
            }
        }

    }

}