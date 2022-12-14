package com.example.newsapp.Retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {

    companion object{

        var BASE_URL ="https://newsapi.org/"

        fun getRetrofit(): Retrofit {
            var retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(
                GsonConverterFactory.create()).build()

            return retrofit
        }

    }
}