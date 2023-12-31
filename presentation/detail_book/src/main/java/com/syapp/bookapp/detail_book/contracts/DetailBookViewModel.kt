package com.syapp.bookapp.detail_book.contracts

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.syapp.bookapp.core.base.BaseViewModel
import com.syapp.bookapp.detail_book.contracts.DetailBookContract.DetailBookSideEffect
import com.syapp.bookapp.detail_book.contracts.DetailBookContract.DetailBookViewEvent
import com.syapp.bookapp.detail_book.contracts.DetailBookContract.DetailBookViewState
import com.syapp.bookapp.domain.input.DetailBookInput
import com.syapp.bookapp.domain.model.state.ActionState
import com.syapp.bookapp.domain.usecase.GetDetailBookUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailBookViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getDetailBookUseCase: GetDetailBookUseCase,
) : BaseViewModel<DetailBookViewState, DetailBookSideEffect, DetailBookViewEvent>(
    DetailBookViewState(actionState = ActionState.contentLoading())
) {

    private val isbn13: String = savedStateHandle[DetailBookContract.KEY_REQUEST_ID] ?: throw IllegalArgumentException()

    init {
        fetchDetailBook()
    }

    private fun fetchDetailBook() {
        viewModelScope.launch {
            updateState {
                copy(actionState = ActionState.contentLoading())
            }

            kotlin.runCatching {
                val detailBook = getDetailBookUseCase.invoke(DetailBookInput(isbn13))

                updateState {
                    copy(
                        actionState = ActionState.None,
                        detailBook = detailBook
                    )
                }
            }.onFailure {
                updateState {
                    copy(
                        actionState = ActionState.Error(it)
                    )
                }
            }
        }
    }
}