package com.ajcm.domain.entities

data class Book(
    val isbn: String,
    val title: String,
    val author: String,
    val description: String,
    val genre: String,
    val img: String,
    val imported: Boolean
)
