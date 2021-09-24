package com.ajcm.bookexample.ui

import com.ajcm.domain.entities.Book

enum class Section {
    BEST_SELLER,
    HISTORY,
    SCIENCE,
    BUSINESS
}

data class BooksSections(val section: Section, val books: List<Book>)

sealed class UiModel {
    object Loading : UiModel()
    class Content(val books: List<BooksSections>) : UiModel()
    object ShowError : UiModel()
}
