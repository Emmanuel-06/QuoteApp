package com.example.quoteapp.repository

import android.util.Log
import com.example.quoteapp.model.Quote
import com.example.quoteapp.network.QuoteApi
import com.example.quoteapp.utils.DataOrException
import retrofit2.Response
import javax.inject.Inject

class QuoteRepository @Inject constructor(
    private val quoteApi: QuoteApi
) {

    suspend fun getQuote(): DataOrException<Quote>{
        return try{
            val quote = quoteApi.getQuote()
            DataOrException(
                data = quote.body(),
                loading = false,
                exception = null
            )
        } catch (e: Exception) {
            Log.d("EXCEPTION", "getQuote: ${e.message}")
            DataOrException(
                data = null,
                loading = false,
                exception = e
            )
        }

    }
}