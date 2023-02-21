package com.tinnovakovic.moviescompose.data.remote

import retrofit2.http.GET

interface MyApi {

    @GET("test")
    fun doNetworkCall()
}