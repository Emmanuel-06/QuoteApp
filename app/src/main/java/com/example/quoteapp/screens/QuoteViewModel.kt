package com.example.quoteapp.screens

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quoteapp.model.Quote
import com.example.quoteapp.repository.QuoteRepository
import com.example.quoteapp.utils.DataOrException
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class QuoteViewModel @Inject constructor(
    private val quoteRepository: QuoteRepository
) : ViewModel() {

//    val _quote = MutableStateFlow(DataOrException<Quote>(data = null))

    val quoteData: MutableState<DataOrException<Quote>> = mutableStateOf(
        DataOrException(
            data = null,
            loading = true,
            exception = null
        )
    )

    init {
        getQuote()
    }

    fun getQuote() {
        viewModelScope.launch {
            quoteData.value.loading = true
            quoteData.value = quoteRepository.getQuote()
            if (quoteData.value.data.toString().isNotEmpty()) {
                quoteData.value.loading = false
            }
        }
    }

}