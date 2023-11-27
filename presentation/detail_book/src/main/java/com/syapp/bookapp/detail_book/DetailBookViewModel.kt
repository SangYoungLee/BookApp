package com.syapp.bookapp.detail_book

import com.syapp.bookapp.core.base.BaseViewModel
import com.syapp.bookapp.detail_book.DetailBookContract.*
import com.syapp.bookapp.domain.model.state.ActionState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailBookViewModel @Inject constructor(

) : BaseViewModel<DetailBookViewState, DetailBookSideEffect, DetailBookViewEvent>(
    DetailBookViewState(actionState = ActionState.contentLoading())
) {

}