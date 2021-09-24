package com.ajcm.domain.usecase

import com.ajcm.domain.entities.Book
import com.ajcm.domain.repository.IBookRepository
import javax.inject.Inject

class GetBooksUC @Inject constructor(private val bookRepository: IBookRepository) {
    suspend operator fun invoke(): List<Book> = bookRepository.getBooks()
}
