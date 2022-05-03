package com.example.presentation.ui.search

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.domain.usecase.Status
import com.example.presentation.base.BaseFragment
import com.example.presentation.databinding.FragmentMoviesSearchBinding
import com.example.presentation.model.MovieItem
import com.example.presentation.util.Codes.NAVIGATE_BACK
import com.example.presentation.util.gone
import com.example.presentation.util.observe
import com.example.presentation.util.visible
import org.koin.android.viewmodel.ext.android.viewModel

class MoviesSearchFragment : BaseFragment<FragmentMoviesSearchBinding,MoviesSearchViewModel>() {

    override val mViewModel: MoviesSearchViewModel by viewModel()
    private val moviesSearchAdapter = MoviesSearchAdapter(::onMovieSearchItemClick)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRV()

        mViewModel.apply {
            observe(mutableLiveData){
                when(it){
                    NAVIGATE_BACK -> requireActivity().onBackPressed()
                }
            }
            observe(resultLiveData) {
                when (it?.status) {
                    Status.SUCCESS -> {
                        binding.let { bi ->
                            bi.progressBar.gone()
                            bi.tvEmptyView.gone()
                            bi.rvMoviesSearch.visible()
                        }
                        movieSearchItemsLiveData.value?.let { items -> moviesSearchAdapter.setList(items) }
                    }
                    Status.ERROR -> {
                        binding.progressBar.gone()
                        Toast.makeText(context,it.message, Toast.LENGTH_LONG).show()
                    }
                    Status.LOADING -> {
                        binding.progressBar.visible()
                    }
                    Status.EMPTY -> {
                        binding.let { bi ->
                            bi.progressBar.gone()
                            bi.rvMoviesSearch.gone()
                            bi.tvEmptyView.visible()
                        }
                    }
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        requestSearchFocus()
    }

    private fun requestSearchFocus(){
        binding.searchEdt.requestFocus()
        openKeyboard()
    }

    private fun initRV(){
        binding.rvMoviesSearch.let {
            val linearLayoutManager = LinearLayoutManager(context)
            it.layoutManager = linearLayoutManager
            it.adapter = moviesSearchAdapter
            it.setHasFixedSize(true)
        }
    }

    private fun onMovieSearchItemClick(item: MovieItem) {
        // TODO:: navigate to movie details fragment
    }
}