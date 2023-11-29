package com.syapp.bookapp.domain.usecase

import com.syapp.bookapp.domain.input.SearchBookInput
import com.syapp.bookapp.domain.model.SearchBookPageInfo
import com.syapp.bookapp.domain.repository.BookRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetSearchBookUseCase @Inject constructor(
    private val repository: BookRepository
) {

    suspend operator fun invoke(input: SearchBookInput): SearchBookPageInfo = withContext(Dispatchers.IO) {
        val apiList = input.query.split("|").map { query ->
            async {
                kotlin.runCatching {
                    getSearchBookListByOrOperator(query, input.page)
                }.getOrElse {
                    SearchBookPageInfo(bookList = emptyList(), hasNext = false)
                }
            }
        }

        apiList.awaitAll().reduce { acc, result ->
            SearchBookPageInfo(
                bookList = acc.bookList + result.bookList,
                hasNext = acc.hasNext || result.hasNext
            )
        }
    }

    private suspend fun getSearchBookListByOrOperator(queryStr: String, page: Int): SearchBookPageInfo {
        val splitedQuery = queryStr.split("-")
        val query = splitedQuery[0]
        val filterTextList = splitedQuery.takeLast(splitedQuery.size - 1)

        if (query.isEmpty()) {
            throw IllegalArgumentException()
        }

        return repository.getSearchBookList(query, page).filterText(filterTextList)
    }

    private fun SearchBookPageInfo.filterText(filterTextList: List<String>): SearchBookPageInfo {
        return copy(
            bookList = bookList.filterNot { book ->
                filterTextList.any { filterText ->
                    book.title?.contains(filterText, ignoreCase = true) ?: false
                }
            }
        )
    }
}