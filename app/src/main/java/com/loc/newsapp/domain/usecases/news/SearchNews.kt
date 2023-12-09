package com.loc.newsapp.domain.usecases.news

import com.loc.newsapp.domain.repository.NewsRepository

class SearchNews(
    private val newsRepository: NewsRepository
) {
    operator fun invoke(searchQuery : String ,sources: List<String>) = newsRepository.searchNews(searchQuery,sources)
}