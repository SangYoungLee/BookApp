package com.syapp.bookapp.domain.repository

import com.syapp.bookapp.domain.model.DetailBook
import com.syapp.bookapp.domain.model.SearchBookPageInfo

interface BookRepository {

    suspend fun getSearchBookList(query: String, page: Int): SearchBookPageInfo
    suspend fun getDetailBook(isbn13: String): DetailBook

}