package com.tinnovakovic.moviescompose.data.repository

import com.tinnovakovic.moviescompose.ApiKey.MOVIE_DB_API_KEY
import com.tinnovakovic.moviescompose.data.models.Movie
import com.tinnovakovic.moviescompose.data.models.returnCleanMovie
import com.tinnovakovic.moviescompose.data.remote.TheMovieDbApi
import com.tinnovakovic.moviescompose.domain.repository.MovieRepo
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MovieRepoImpl @Inject constructor(private val movieDbApi: TheMovieDbApi) : MovieRepo {

    override fun getTopRatedMovies(): Single<List<Movie>> =
        movieDbApi.getTopRatedMovies(
            MOVIE_DB_API_KEY
        )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .flattenAsObservable { it.results }
            .map { it.returnCleanMovie() }
            .toList()
            .retry(RETRIES)


    override fun getDetails() {
        TODO("Use Zip to combine the network calls and return Single<DetailMovie>")
    }

    companion object {
        const val RETRIES = 2L
    }

}