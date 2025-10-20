package com.example.quoteapp.utils

import java.lang.Exception

class DataOrException <T>(
    var data: T?,
    var loading: Boolean = false,
    var exception: Exception? = null
)