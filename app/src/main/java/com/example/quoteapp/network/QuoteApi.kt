package com.example.quoteapp.network

import com.example.quoteapp.model.Quote
import retrofit2.Response
import retrofit2.http.GET
import javax.inject.Singleton

@Singleton
interface QuoteApi {
    @GET("stoic-quote")
    suspend fun getQuote(): Response<Quote>
}