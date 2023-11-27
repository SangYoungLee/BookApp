package com.syapp.bookapp.detail_book

import com.syapp.bookapp.core.base.ViewEvent
import com.syapp.bookapp.core.base.ViewSideEffect
import com.syapp.bookapp.core.base.ViewState
import com.syapp.bookapp.domain.model.DetailBook
import com.syapp.bookapp.domain.model.state.ActionState

interface DetailBookContract {

    data class DetailBookViewState(
        val actionState: ActionState = ActionState.None,
        val detailBook: DetailBook? = null,
    ) : ViewState

    sealed interface DetailBookSideEffect : ViewSideEffect {

    }

    sealed interface DetailBookViewEvent : ViewEvent {

    }
}