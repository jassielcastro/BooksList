package com.ajcm.data.datasource

import com.ajcm.domain.entities.BestSeller
import com.ajcm.domain.entities.Book

interface IRemoteBooksDataSource {
    suspend fun getBooks(): List<Book>
    suspend fun getBestSellers(): List<BestSeller>
}
