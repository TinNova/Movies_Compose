package com.tinnovakovic.moviescompose.domain.repository

import com.tinnovakovic.moviescompose.data.models.Movie
import io.reactivex.Single

interface MovieRepo {

    fun getTopRatedMovies(): Single<List<Movie>> //returns List of Movie object (NOT MovieResult)

    fun getDetails() //returns object containing all data for Detail

}