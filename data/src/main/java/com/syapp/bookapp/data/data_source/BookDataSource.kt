package com.syapp.bookapp.data.data_source

import com.syapp.bookapp.data.response.SearchedBookResponse

interface BookDataSource {

    suspend fun getSearchBookList(
        query: String,
        page: Int,
    ): SearchedBookResponse
}