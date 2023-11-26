package com.syapp.bookapp.search_book

import com.syapp.bookapp.domain.model.Book
import com.syapp.styleapp.common.base.ViewEvent
import com.syapp.styleapp.common.base.ViewSideEffect
import com.syapp.styleapp.common.base.ViewState

interface SearchBookContract {

    data class SearchBookViewState(
        val isLoading: Boolean = false,
        val bookList: List<Book> = emptyList(),
        val error: Throwable? = null,
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
        class OnTextChanged(val text: String?) : SearchBookViewEvent
    }
}