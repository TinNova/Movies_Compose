package com.tinnovakovic.moviescompose.data.repository

import com.tinnovakovic.moviescompose.data.remote.MyApi
import com.tinnovakovic.moviescompose.domain.repository.MyRepo
import javax.inject.Inject

class MyRepoImpl @Inject constructor(private val myApi: MyApi) : MyRepo {
    override fun doNetworkCall() {
    }

}