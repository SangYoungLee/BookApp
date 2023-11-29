package com.syapp.bookapp.domain.input

data class SearchBookInput(
    val query: String,
    val page: Int,
) {
    companion object {
        const val INITIAL_PAGE_INDEX = 1
        const val INCREASE_PER_PAGE = 1
    }
}