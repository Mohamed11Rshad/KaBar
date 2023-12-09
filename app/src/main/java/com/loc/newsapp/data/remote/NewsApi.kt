package com.loc.newsapp.data.remote

import com.loc.newsapp.data.remote.dto.NewsResponse
import com.loc.newsapp.util.Constants.NEWS_API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("everything")
    suspend fun getNews(
        @Query("page") page : Int,
        @Query("sources") sources : String,
        @Query("apiKey") apiKey : String = NEWS_API_KEY
    ): NewsResponse

    @GET("everything")
    suspend fun searchNews(
        @Query("page") page : Int,
        @Query("q") searchQuery : String,
        @Query("sources") sources : String,
        @Query("apiKey") apiKey : String = NEWS_API_KEY
    ): NewsResponse

}