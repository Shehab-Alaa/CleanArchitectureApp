package com.example.presentation.model

import com.example.domain.model.Movie

fun generateMoviesList() = listOf(
    Movie(
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

fun generateErrorMessage() = "Network Error"

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

fun generatePresentationModel() = MovieItem(
    id = 0,
    title = "title",
    adult = false,
    backdropPath = "https://image.tmdb.org/t/p/w780backdropPath",
    genreIds = listOf(),
    originalLanguage = "language",
    originalTitle = "title",
    overview = "overview",
    popularity = 0.0,
    posterPath = "https://image.tmdb.org/t/p/w342posterPath",
    releaseDate = "date",
    video = false,
    voteAverage = 0.0,
    voteCount = 0
)