package com.tinnovakovic.moviescompose.data.models

import com.tin.popularmovies.Const.BASE_IMAGE_MEDIUM

data class Detail(
    val adult: Boolean = false,
    val backdrop_path: String = "",
    val belongsToCollection: Any = Any(), //belongs_to_collection
    val budget: Int = 0,
    val genres: List<Genre> = listOf(),
    val homepage: String = "",
    val id: Int = 0,
    val imdb_id: String = "",
    val original_language: String = "",
    val original_title: String = "",
    val overview: String = "",
    val popularity: Double = 0.0,
    val poster_path: String = "",
    val production_companies: List<ProductionCompany> = listOf(),
    val production_countries: List<ProductionCountry> = listOf(),
    val release_date: String = "",
    val revenue: Int = 0,
    val runtime: Int = 0,
    val spoken_languages: List<SpokenLanguage> = listOf(),
    val status: String = "",
    val tagline: String = "",
    val title: String = "",
    val video: Boolean = false,
    val vote_average: Double = 0.0,
    val vote_count: Int = 0
)

data class Genre(
    val id: Int,
    val name: String
)

data class ProductionCompany(
    val id: Int,
    val name: String,
    val origin_country: String,
    val logo_path: String
)

data class ProductionCountry(
    val iso_3166_1: String,
    val name: String
)

data class SpokenLanguage(
    val iso_639_1: String,
    val name: String
)


fun Detail.returnCleanDetail() =
    Detail(
        id = id,
        title = title,
        vote_average = vote_average,
        release_date = release_date,
        overview = overview,
        poster_path = BASE_IMAGE_MEDIUM + poster_path,
        backdrop_path = BASE_IMAGE_MEDIUM + backdrop_path
    )
