package com.tinnovakovic.moviescompose.data.di

import com.tinnovakovic.moviescompose.data.repository.MovieRepoImpl
import com.tinnovakovic.moviescompose.data.repository.MyRepoImpl
import com.tinnovakovic.moviescompose.domain.repository.MovieRepo
import com.tinnovakovic.moviescompose.domain.repository.MyRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindMyRepo(
        myRepo: MyRepoImpl
    ): MyRepo

    @Binds
    @Singleton
    abstract fun bindMovieRepo(
        movieRepo: MovieRepoImpl
    ): MovieRepo
}