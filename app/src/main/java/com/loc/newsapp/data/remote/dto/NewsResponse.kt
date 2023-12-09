package com.loc.newsapp.data.remote.dto


import com.google.gson.annotations.SerializedName
import com.loc.newsapp.domain.model.Article

data class NewsResponse(
    @SerializedName("articles")
    val articles: List<Article>,
    @SerializedName("status")
    val status: String,
    @SerializedName("totalResults")
    val totalResults: Int
)