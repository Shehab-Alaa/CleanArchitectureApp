package com.example.presentation.ui.fragment.movie

import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.movie.GetMoviesUseCase
import com.example.presentation.base.BaseViewModel
import com.example.presentation.mapper.MovieItemMapper
import com.example.presentation.model.MovieItem
import com.example.presentation.util.Resource
import kotlinx.coroutines.launch
import timber.log.Timber

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
            getMoviesUseCase.createObservable()
                .map { it.map { movie -> movieItemMapper.mapToPresentation(movie) } }
                .subscribe({
                    adapter.setList(it)
                    postResult(Resource.success())
                }, {
                    Timber.e("Get movies error: $it")
                    postResult(Resource.message(it.message))
                })
        }
    }
}