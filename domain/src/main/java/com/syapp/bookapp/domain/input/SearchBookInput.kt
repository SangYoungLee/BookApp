package com.syapp.bookapp.domain.input

data class SearchBookInput(
    val query: String,
    val page: Int,
)