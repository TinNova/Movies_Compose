package com.tinnovakovic.moviescompose

import androidx.lifecycle.ViewModel
import com.tinnovakovic.moviescompose.domain.repository.MovieRepo
import com.tinnovakovic.moviescompose.domain.repository.MyRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(movieRepo: MovieRepo): ViewModel() {


    init {
        movieRepo.getTopRatedMovies()
    }
}