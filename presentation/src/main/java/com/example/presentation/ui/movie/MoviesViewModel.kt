package com.example.presentation.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.Resource
import com.example.domain.usecase.Status
import com.example.domain.usecase.movie.GetMoviesUseCase
import com.example.presentation.base.BaseViewModel
import com.example.presentation.mapper.MovieMapper
import com.example.presentation.model.MovieItem
import kotlinx.coroutines.launch

class MoviesViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val movieMapper: MovieMapper) : BaseViewModel(){

    private val movieItems = MutableLiveData<List<MovieItem>>()
    val movieItemsLiveData : LiveData<List<MovieItem>> get() = movieItems

    fun getPopularMoviesAsync(){
        viewModelScope.launch {
            postResult(Resource.loading())
            val result = getMoviesUseCase.executeAsync()
            when (result.status){
                Status.SUCCESS -> {
                    movieItems.value = result.data?.map { movieMapper.mapToPresentation(it) }
                    postResult(Resource.success(movieItems.value))
                } else -> {
                    postResult(result)
                }
            }
        }
    }
}