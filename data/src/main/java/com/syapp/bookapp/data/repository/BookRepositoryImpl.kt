package com.syapp.bookapp.data.repository

import com.syapp.bookapp.data.data_source.BookDataSource
import com.syapp.bookapp.data.mapper.BookMapper
import com.syapp.bookapp.domain.model.DetailBook
import com.syapp.bookapp.domain.model.SearchBookPageInfo
import com.syapp.bookapp.domain.repository.BookRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

internal class BookRepositoryImpl @Inject constructor(
    private val dataSource: BookDataSource
) : BookRepository {

    override suspend fun getSearchBookList(query: String, page: Int): SearchBookPageInfo = withContext(Dispatchers.IO) {
        BookMapper.mapToSearchBookPageInfo(dataSource.getSearchBookList(query, page))
    }

    override suspend fun getDetailBook(isbn13: String): DetailBook = withContext(Dispatchers.IO) {
        BookMapper.mapToDetailBook(dataSource.getDetailBook(isbn13))
    }
}