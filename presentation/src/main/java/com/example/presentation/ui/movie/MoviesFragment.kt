package com.example.presentation.ui.movie

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.domain.usecase.Status
import com.example.presentation.R
import com.example.presentation.base.BaseFragment
import com.example.presentation.databinding.FragmentMoviesBinding
import com.example.presentation.model.MovieItem
import com.example.presentation.util.*
import org.koin.android.viewmodel.ext.android.viewModel

class MoviesFragment : BaseFragment<FragmentMoviesBinding, MoviesViewModel>() {

    override val mViewModel: MoviesViewModel by viewModel()
    private val moviesAdapter = MoviesAdapter(::onMovieItemClick)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpToolbar()
        initRV()

        mViewModel.apply {
            getPopularMoviesAsync()
            observe(resultLiveData) {
                when (it?.status) {
                    Status.SUCCESS -> {
                        binding.progressBar.gone()
                        binding.rvMovies.visible()
                        movieItemsLiveData.value?.let { items -> moviesAdapter.addList(items) }
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

    private fun setUpToolbar(){
        binding.toolbar.let {
            it.inflateMenu(R.menu.main_menu)
            it.setOnMenuItemClickListener { item ->
                when(item.itemId) {
                    R.id.action_search -> navigateSafe(MoviesFragmentDirections.actionMoviesFragmentToMoviesSearchFragment())
                }
                true
            }
        }
    }

    private fun initRV(){
        binding.rvMovies.let {
            val linearLayoutManager = LinearLayoutManager(context)
            it.layoutManager = linearLayoutManager
            it.adapter = moviesAdapter
            it.setHasFixedSize(true)
            it.addOnScrollListener(EndlessScrollListener(linearLayoutManager){
                mViewModel.getPopularMoviesAsync()
            })
        }
    }

    private fun onMovieItemClick(item: MovieItem) {
        // TODO:: navigate to movie details fragment
    }

}