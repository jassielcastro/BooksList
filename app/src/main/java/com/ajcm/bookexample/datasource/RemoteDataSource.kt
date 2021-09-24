package com.ajcm.bookexample.datasource

import com.ajcm.bookexample.server.BookApi
import com.ajcm.data.datasource.IRemoteBooksDataSource
import com.ajcm.domain.entities.BestSeller
import com.ajcm.domain.entities.Book
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val api: BookApi) : IRemoteBooksDataSource {
    override suspend fun getBooks(): List<Book> {
        return api.getBooksAsync().await().results.books
    }

    override suspend fun getBestSellers(): List<BestSeller> {
        return api.getBestSellersAsync().await().results.best_sellers.map { BestSeller(it) }
    }
}
