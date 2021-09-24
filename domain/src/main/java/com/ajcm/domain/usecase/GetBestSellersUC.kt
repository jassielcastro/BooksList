package com.ajcm.domain.usecase

import com.ajcm.domain.entities.Book
import com.ajcm.domain.repository.IBookRepository
import javax.inject.Inject

class GetBestSellersUC @Inject constructor(private val bookRepository: IBookRepository) {
    suspend operator fun invoke(): List<Book> {
        val ids = bookRepository.getBestSellers()
        val books = bookRepository.getBooks()
        return books.filter { book ->
            ids.map { it.bookId }.contains(book.isbn)
        }
    }
}
