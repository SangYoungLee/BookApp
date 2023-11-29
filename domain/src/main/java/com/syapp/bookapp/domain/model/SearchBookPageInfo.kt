package com.syapp.bookapp.domain.model

data class SearchBookPageInfo(
    val bookList: List<Book>,
    val hasNext: Boolean
) {
}