package com.mahlingaprasad.newsapp.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {
    companion object{
        private const val BaseURL ="https://newsapi.org/v2/"

        fun getRetroInstance(): Retrofit {
            return Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BaseURL)
                    .build()
        }
    }
}