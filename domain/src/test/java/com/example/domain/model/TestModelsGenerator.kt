package com.example.domain.model

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

fun generateEmptyMoviesList() = listOf<Movie>()

fun getExceptionMessage() = "null"