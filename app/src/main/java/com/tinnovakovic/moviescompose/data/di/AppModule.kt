package com.tinnovakovic.moviescompose.data.di

import com.tinnovakovic.moviescompose.data.remote.MyApi
import com.tinnovakovic.moviescompose.data.repository.MyRepoImpl
import com.tinnovakovic.moviescompose.domain.repository.MyRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
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

//    @Provides
//    @Singleton
//    fun provideMyRepo(myApi: MyApi): MyRepo {
//        return MyRepoImpl(myApi)
//    }
}