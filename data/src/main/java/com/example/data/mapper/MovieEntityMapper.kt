package com.example.data.mapper

import com.example.data.base.EntityMapper
import com.example.data.model.MovieEntity
import com.example.domain.model.Movie

class MovieEntityMapper : EntityMapper<Movie,MovieEntity> {

    override fun mapToDomain(entity: MovieEntity): Movie {
        return Movie(
            id = entity.id,
            title = entity.title,
            adult = entity.adult,
            backdropPath = entity.backdropPath,
            genreIds = entity.genreIds,
            originalLanguage = entity.originalLanguage,
            originalTitle = entity.originalTitle,
            overview = entity.overview,
            popularity = entity.popularity,
            posterPath = entity.posterPath,
            releaseDate = entity.releaseDate,
            video = entity.video,
            voteAverage = entity.voteAverage,
            voteCount = entity.voteCount
        )
    }

    override fun mapToEntity(model: Movie): MovieEntity {
        return MovieEntity(
            id = model.id,
            title = model.title,
            adult = model.adult,
            backdropPath = model.backdropPath,
            genreIds = model.genreIds,
            originalLanguage = model.originalLanguage,
            originalTitle = model.originalTitle,
            overview = model.overview,
            popularity = model.popularity,
            posterPath = model.posterPath,
            releaseDate = model.releaseDate,
            video = model.video,
            voteAverage = model.voteAverage,
            voteCount = model.voteCount
        )
    }
}