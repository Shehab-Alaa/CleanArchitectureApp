package com.example.presentation.ui

import androidx.lifecycle.viewModelScope
import com.example.domain.base.Resource
import com.example.domain.base.Status
import com.example.domain.usecase.movie.GetMoviesUseCase
import com.example.presentation.base.BaseViewModel
import com.example.presentation.mapper.MovieItemMapper
import com.example.presentation.model.MovieItem
import kotlinx.coroutines.launch

class MoviesViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val movieItemMapper: MovieItemMapper) : BaseViewModel(){

    val adapter = MoviesAdapter(::onAdapterItemClick)

    init {
        getPopularMoviesAsync()
    }

    private fun onAdapterItemClick(item: MovieItem) {
        setValue(item)
    }

    private fun getPopularMoviesAsync(){
        viewModelScope.launch {
            postResult(Resource.loading())
            val result = getMoviesUseCase.executeAsync()
            when (result.status){
                Status.SUCCESS -> {
                    val moviesItems = result.data?.map { movieItemMapper.mapToPresentation(it) }
                    moviesItems?.let { adapter.setList(it) }
                    postResult(Resource.success(moviesItems))
                } else -> {
                    postResult(result)
                }
            }
        }
    }
}