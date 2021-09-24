package com.ajcm.domain.repository

import com.ajcm.domain.entities.BestSeller
import com.ajcm.domain.entities.Book

interface IBookRepository {
    suspend fun getBooks(): List<Book>
    suspend fun getBestSellers(): List<BestSeller>
}
