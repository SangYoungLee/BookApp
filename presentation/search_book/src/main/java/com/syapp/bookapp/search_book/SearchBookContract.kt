package com.syapp.bookapp.search_book

import com.syapp.bookapp.domain.input.SearchBookInput.Companion.INITIAL_PAGE_INDEX
import com.syapp.bookapp.domain.model.Book
import com.syapp.bookapp.core.base.ViewEvent
import com.syapp.bookapp.core.base.ViewSideEffect
import com.syapp.bookapp.core.base.ViewState

interface SearchBookContract {

    data class SearchBookViewState(
        val isLoading: Boolean = false,
        val isMoreLoading: Boolean = false,
        val error: Throwable? = null,
        val query: String = "",
        val bookList: List<Book> = emptyList(),
        val page: Int = INITIAL_PAGE_INDEX,
    ) : ViewState {
        val hasError: Boolean
            get() = error != null
    }

    sealed interface SearchBookViewSideEffect : ViewSideEffect {
        class MoveToDetailBook(
            val isbn13: String
        ) : SearchBookViewSideEffect
    }

    sealed interface SearchBookViewEvent : ViewEvent {
        class OnTextChanged(val text: String) : SearchBookViewEvent
    }
}