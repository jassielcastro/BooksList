package com.ajcm.data

import com.ajcm.data.datasource.IRemoteBooksDataSource
import com.ajcm.domain.entities.BestSeller
import com.ajcm.domain.entities.Book
import com.ajcm.domain.repository.IBookRepository
import javax.inject.Inject

class BookRepository @Inject constructor(
    private val remoteDataSource: IRemoteBooksDataSource
) : IBookRepository {

    override suspend fun getBooks(): List<Book> {
        return remoteDataSource.getBooks()
    }

    override suspend fun getBestSellers(): List<BestSeller> {
        return remoteDataSource.getBestSellers()
    }
}
