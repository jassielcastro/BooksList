package com.ajcm.bookexample.server

import com.ajcm.domain.entities.BestSeller
import com.ajcm.domain.entities.Book
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface BookApi {

    @GET("/files/main/best_sellers.json")
    fun getBestSellersAsync(): Deferred<List<BestSeller>>

    @GET("/files/main/books.json")
    fun getBooksAsync(): Deferred<List<Book>>

}
