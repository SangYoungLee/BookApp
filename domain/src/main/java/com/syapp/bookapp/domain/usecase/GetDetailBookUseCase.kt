package com.syapp.bookapp.domain.usecase

import com.syapp.bookapp.domain.input.DetailBookInput
import com.syapp.bookapp.domain.model.DetailBook
import com.syapp.bookapp.domain.repository.BookRepository
import javax.inject.Inject

class GetDetailBookUseCase @Inject constructor(
    private val repository: BookRepository
) {

    suspend operator fun invoke(input: DetailBookInput): DetailBook {
        return repository.getDetailBook(input.isbn13)
    }
}