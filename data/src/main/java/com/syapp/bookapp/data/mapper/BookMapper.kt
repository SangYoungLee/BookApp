package com.syapp.bookapp.data.mapper

import com.syapp.bookapp.data.response.DetailBookResponse
import com.syapp.bookapp.data.response.SearchedBookResponse
import com.syapp.bookapp.domain.error.NoDataException
import com.syapp.bookapp.domain.error.ServerException
import com.syapp.bookapp.domain.model.DetailBook
import com.syapp.bookapp.domain.model.SearchBookPageInfo

object BookMapper {

    fun mapToSearchBookPageInfo(response: SearchedBookResponse): SearchBookPageInfo {
        if ((response.error?.toIntOrNull() ?: 0) > 0) {
            throw ServerException(response.error.orEmpty())
        }

        return SearchBookPageInfo(
            bookList = response.books ?: throw NoDataException(),
            hasNext = response.books.isNotEmpty()
        )
    }

    fun mapToDetailBook(response: DetailBookResponse): DetailBook {
        if ((response.error?.toIntOrNull() ?: 0) > 0) {
            throw ServerException(response.error.orEmpty())
        }

        return DetailBook(
            authors = response.authors,
            desc = response.desc,
            image = response.image,
            language = response.language,
            pages = response.pages,
            price = response.price,
            subtitle = response.subtitle,
            title = response.title,
            year = response.year,
        )
    }
}