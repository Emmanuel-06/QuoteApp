package com.example.quoteapp.model

import com.google.gson.annotations.SerializedName

data class Quote(
    @SerializedName("data")
    val data: Data
)

