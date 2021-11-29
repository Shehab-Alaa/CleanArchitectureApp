package com.example.presentation.mapper

import com.example.domain.model.Movie
import com.example.presentation.base.ItemMapper
import com.example.presentation.model.MovieItem

class MovieItemMapper : ItemMapper<Movie,MovieItem> {

    override fun mapToPresentation(model: Movie): MovieItem {
        return MovieItem(

        )
    }

    override fun mapToDomain(modelItem: MovieItem): Movie {
        return Movie(

        )
    }
}