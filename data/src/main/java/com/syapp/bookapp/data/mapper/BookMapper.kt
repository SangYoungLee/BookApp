package com.syapp.bookapp.data.mapper

import com.syapp.bookapp.data.response.DetailBookResponse
import com.syapp.bookapp.data.response.SearchedBookResponse
import com.syapp.bookapp.domain.model.DetailBook
import com.syapp.bookapp.domain.model.SearchBookPageInfo

object BookMapper {

    fun mapToSearchBookPageInfo(response: SearchedBookResponse): SearchBookPageInfo {
        return SearchBookPageInfo(
            bookList = response.books.orEmpty()
        )
    }

    fun mapToDetailBook(response: DetailBookResponse): DetailBook {
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