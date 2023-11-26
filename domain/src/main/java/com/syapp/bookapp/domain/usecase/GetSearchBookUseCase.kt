package com.syapp.bookapp.domain.usecase

import com.syapp.bookapp.domain.input.SearchBookInput
import com.syapp.bookapp.domain.model.SearchBookPageInfo
import com.syapp.bookapp.domain.repository.BookRepository
import javax.inject.Inject

class GetSearchBookUseCase @Inject constructor(
    private val repository: BookRepository
) {

    suspend operator fun invoke(input: SearchBookInput): SearchBookPageInfo {
        return repository.getSearchBookList(input.query, input.page)
    }
}