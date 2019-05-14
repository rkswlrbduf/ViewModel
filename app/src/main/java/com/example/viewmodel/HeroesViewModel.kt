package com.example.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HeroesViewModel : ViewModel() {

    private var heroList = MutableLiveData<ArrayList<Hero>>()

    fun getHeroes(): LiveData<ArrayList<Hero>> {
        loadHeroes()
        return heroList
    }

    fun loadHeroes() {
        var retrofit = Retrofit.Builder().baseUrl(API.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
        var api = retrofit.create(API::class.java)
        var lists: Call<ArrayList<Hero>> = api.getHeroes()
        lists.enqueue(object : Callback<ArrayList<Hero>> {
            override fun onResponse(call: Call<ArrayList<Hero>>, response: Response<ArrayList<Hero>>) {
                heroList.value = response.body()
                Log.d("TAG", "CALLED")
            }
            override fun onFailure(call: Call<ArrayList<Hero>>, t: Throwable) {
                Log.e("TAG", t.message)
            }
        })
    }

}