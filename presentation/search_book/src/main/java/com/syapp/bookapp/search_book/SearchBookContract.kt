package com.syapp.bookapp.search_book

import androidx.annotation.StringRes
import com.syapp.bookapp.core.base.ViewEvent
import com.syapp.bookapp.core.base.ViewSideEffect
import com.syapp.bookapp.core.base.ViewState
import com.syapp.bookapp.domain.input.SearchBookInput.Companion.INITIAL_PAGE_INDEX
import com.syapp.bookapp.domain.model.Book
import com.syapp.bookapp.domain.model.state.ActionState

interface SearchBookContract {

    data class SearchBookViewState(
        val actionState: ActionState = ActionState.None,
        val query: String = "",
        val bookList: List<Book> = emptyList(),
        val page: Int = INITIAL_PAGE_INDEX,
        val hasNext: Boolean = false,
    ) : ViewState

    sealed interface SearchBookViewSideEffect : ViewSideEffect {
        data class MoveToDetailBook(
            val isbn13: String
        ) : SearchBookViewSideEffect

        data class ShowToast(
            @StringRes val messageResId: Int
        ) : SearchBookViewSideEffect
    }

    sealed interface SearchBookViewEvent : ViewEvent {
        data class OnTextChanged(val text: String) : SearchBookViewEvent
        data class OnClickBook(val book: Book) : SearchBookViewEvent
        object OnLoadMore : SearchBookViewEvent
    }
}