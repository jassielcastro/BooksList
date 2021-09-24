package com.ajcm.bookexample.server

import com.ajcm.domain.entities.Book
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

data class Results<T>(val results: BookResponse<T>)
data class BookResponse<T>(val books: T)

data class BSResults<T>(val results: BestSellerResponse<T>)
data class BestSellerResponse<T>(val best_sellers: T)

interface BookApi {

    @GET("files/main/best_sellers.json")
    fun getBestSellersAsync(): Deferred<BSResults<List<String>>>

    @GET("files/main/books.json")
    fun getBooksAsync(): Deferred<Results<List<Book>>>

}
