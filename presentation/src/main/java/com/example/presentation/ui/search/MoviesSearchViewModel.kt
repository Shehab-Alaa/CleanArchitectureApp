package com.example.presentation.ui.search

import androidx.databinding.adapters.TextViewBindingAdapter
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.Resource
import com.example.domain.usecase.Status
import com.example.domain.usecase.movie.GetMoviesSearchUseCase
import com.example.domain.usecase.movie.GetMoviesSearchUseCase.Companion.QUERY_PARAM
import com.example.presentation.base.BaseViewModel
import com.example.presentation.mapper.MovieMapper
import com.example.presentation.model.MovieItem
import com.example.presentation.util.Codes.NAVIGATE_BACK
import kotlinx.coroutines.launch

class MoviesSearchViewModel(
    private val getMoviesSearchUseCase: GetMoviesSearchUseCase,
    private val movieMapper: MovieMapper
) : BaseViewModel(){

    private val movieSearchItems = MutableLiveData<List<MovieItem>>()
    val movieSearchItemsLiveData : LiveData<List<MovieItem>> get() = movieSearchItems

    private fun getMoviesSearchAsync(query: String){
        viewModelScope.launch {
            postResult(Resource.loading())
            val result = getMoviesSearchUseCase.executeAsync(mapOf(QUERY_PARAM to query))
            when (result.status){
                Status.SUCCESS -> {
                    movieSearchItems.value = result.data?.map { movieMapper.mapToPresentation(it) }
                    postResult(Resource.success(movieSearchItems.value))
                } else -> {
                    postResult(result)
                }
            }
        }
    }

    fun onTextChange(): TextViewBindingAdapter.OnTextChanged {
        return TextViewBindingAdapter.OnTextChanged { s, _, _, _ ->
            if (s.isEmpty()){
                postResult(Resource.empty())
            }else {
                getMoviesSearchAsync(s.toString())
            }
        }
    }

    fun onBackBtnPressed(){
        setValue(NAVIGATE_BACK)
    }
}