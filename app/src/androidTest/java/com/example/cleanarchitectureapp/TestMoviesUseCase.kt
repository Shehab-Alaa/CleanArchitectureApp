package com.example.cleanarchitectureapp

import android.content.Context
import com.example.cleanarchitectureapp.TestUtil.getDummyMoviesData
import com.example.cleanarchitectureapp.TestUtil.resourceStatus
import com.example.domain.model.Movie
import com.example.domain.repository.IMoviesRepository
import com.example.domain.usecase.Resource
import com.example.domain.usecase.Status
import com.example.domain.usecase.movie.GetMoviesUseCase

class TestMoviesUseCase(
    private val app: Context,
    moviesRepository: IMoviesRepository
) : GetMoviesUseCase(moviesRepository) {

    override suspend fun executeAsync(): Resource<List<Movie>> {
        return when(resourceStatus.status){
            Status.SUCCESS -> Resource.success(getDummyMoviesData(app))
            Status.EMPTY -> Resource.empty()
            Status.ERROR -> Resource.error(app.getString(R.string.network_error))
            Status.LOADING -> TODO()
        }
    }
}