package com.example.data.model

import com.example.domain.model.Movie

fun generateDomainModel() = Movie(
    id = 0,
    title = "title",
    adult = false,
    backdropPath = "backdropPath",
    genreIds = listOf(),
    originalLanguage = "language",
    originalTitle = "title",
    overview = "overview",
    popularity = 0.0,
    posterPath = "posterPath",
    releaseDate = "date",
    video = false,
    voteAverage = 0.0,
    voteCount = 0
)

fun generateEntityModel() = MovieEntity(
    id = 0,
    title = "title",
    adult = false,
    backdropPath = "backdropPath",
    genreIds = listOf(),
    originalLanguage = "language",
    originalTitle = "title",
    overview = "overview",
    popularity = 0.0,
    posterPath = "posterPath",
    releaseDate = "date",
    video = false,
    voteAverage = 0.0,
    voteCount = 0
)

fun generateMoviesList() = listOf(
    MovieEntity(
        id = 0,
        title = "title",
        adult = false,
        backdropPath = "backdropPath",
        genreIds = listOf(),
        originalLanguage = "language",
        originalTitle = "title",
        overview = "overview",
        popularity = 0.0,
        posterPath = "posterPath",
        releaseDate = "date",
        video = false,
        voteAverage = 0.0,
        voteCount = 0
    ),
)