package com.example.newsapp.Retrofit

import com.example.newsapp.ModelData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {


    @GET("v2/top-headlines")
    fun getData(@Query("country")country:String,@Query("category")category:String,@Query("apiKey")apiKey :String): Call<ModelData>
}