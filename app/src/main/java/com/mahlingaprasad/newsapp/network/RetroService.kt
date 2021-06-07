package com.mahlingaprasad.newsapp.network

import com.mahlingaprasad.newsapp.models.News
import retrofit2.http.GET
import retrofit2.http.Query

interface RetroService {

    @GET("everything")
    suspend fun getDataFromAPI(@Query("q") query : String, @Query("from") date : String, @Query("sortBy") sortBy : String, @Query("apiKey") apiKey : String) : News
}