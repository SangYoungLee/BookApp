package com.syapp.bookapp.data.mapper

import com.syapp.bookapp.data.response.SearchedBookResponse
import com.syapp.bookapp.domain.model.SearchBookPageInfo

object BookMapper {

    fun mapToSearchBookPageInfo(response: SearchedBookResponse): SearchBookPageInfo {
        return SearchBookPageInfo(
            bookList = response.books
        )
    }
}