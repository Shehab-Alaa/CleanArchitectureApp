package com.example.data.mapper

import com.example.data.base.EntityMapper
import com.example.data.model.MovieEntity
import com.example.domain.model.Movie

class MovieEntityMapper : EntityMapper<Movie,MovieEntity> {

    override fun mapToDomain(entity: MovieEntity): Movie {
        return Movie(

        )
    }

    override fun mapToEntity(model: Movie): MovieEntity {
        return MovieEntity(

        )
    }
}