package com.example.viewmodel

import retrofit2.Call
import retrofit2.http.GET


interface API {

    @GET("marvel")
    fun getHeroes(): Call<ArrayList<Hero>>

    companion object {
        val BASE_URL = "https://simplifiedcoding.net/demos/"
    }

}