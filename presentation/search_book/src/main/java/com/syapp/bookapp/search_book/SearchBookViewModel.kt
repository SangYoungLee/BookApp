package com.syapp.bookapp.search_book

import com.syapp.bookapp.domain.usecase.GetSearchBookUseCase
import com.syapp.bookapp.search_book.SearchBookContract.*
import com.syapp.styleapp.common.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchBookViewModel @Inject constructor(
    private val getSearchBookUseCase: GetSearchBookUseCase
) : BaseViewModel<SearchBookViewState, SearchBookViewSideEffect, SearchBookViewEvent>(
    SearchBookViewState()
) {


}