package com.syapp.bookapp.domain.usecase

import com.syapp.bookapp.domain.input.SearchBookInput
import com.syapp.bookapp.domain.model.SearchBookPageInfo
import com.syapp.bookapp.domain.repository.BookRepository
import javax.inject.Inject

class GetSearchBookUseCase @Inject constructor(
    private val repository: BookRepository
) {

    suspend operator fun invoke(input: SearchBookInput): SearchBookPageInfo {
        val splitedQuery = input.query.split("-")
        val query = splitedQuery[0]
        val notContainTextList = splitedQuery.takeLast(splitedQuery.size - 1)

        return repository.getSearchBookList(query, input.page).run {
            copy(
                bookList = bookList.filterNot { book ->
                    notContainTextList.any { filterText ->
                        book.title?.contains(filterText, ignoreCase = true) ?: false
                    }
                }
            )
        }
    }
}