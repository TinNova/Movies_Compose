package com.tinnovakovic.moviescompose.data.di

import android.app.Application
import com.tinnovakovic.moviescompose.data.remote.MyApi
import com.tinnovakovic.moviescompose.data.remote.TheMovieDbApi
import com.tinnovakovic.moviescompose.data.repository.MyRepoImpl
import com.tinnovakovic.moviescompose.domain.repository.MyRepo
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMyApi(): MyApi {
        return Retrofit.Builder()
            .baseUrl("https://test.com")
            .build()
            .create(MyApi::class.java)
    }

    private val cacheSizeBytes = 1024 * 1024 * 5

    @Provides
    @Singleton
    fun providesRetrofit(cache: Cache, okHttpClient: OkHttpClient.Builder): TheMovieDbApi =
        Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/")
            .client(okHttpClient
                .cache(cache)
                .build()
            )
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(TheMovieDbApi::class.java)

    @Provides
    @Singleton
    fun providesOkHttpClient(): OkHttpClient.Builder =
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))

    @Provides
    @Singleton
    fun provideCache(application: Application): Cache = Cache(application.cacheDir, cacheSizeBytes.toLong())

}
