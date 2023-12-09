package com.loc.newsapp.domain.usecases.news

import com.loc.newsapp.domain.repository.NewsRepository

class GetNews(
    private val newsRepository: NewsRepository
) {
    operator fun invoke(sources: List<String>) = newsRepository.getNews(sources)
}