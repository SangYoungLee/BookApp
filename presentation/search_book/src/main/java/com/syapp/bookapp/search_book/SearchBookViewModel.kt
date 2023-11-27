package com.syapp.bookapp.search_book

import androidx.lifecycle.viewModelScope
import com.syapp.bookapp.core.base.BaseViewModel
import com.syapp.bookapp.domain.input.SearchBookInput
import com.syapp.bookapp.domain.input.SearchBookInput.Companion.INCREASE_PER_PAGE
import com.syapp.bookapp.domain.input.SearchBookInput.Companion.INITIAL_PAGE_INDEX
import com.syapp.bookapp.domain.model.Book
import com.syapp.bookapp.domain.usecase.GetSearchBookUseCase
import com.syapp.bookapp.search_book.SearchBookContract.SearchBookViewEvent
import com.syapp.bookapp.search_book.SearchBookContract.SearchBookViewSideEffect
import com.syapp.bookapp.search_book.SearchBookContract.SearchBookViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchBookViewModel @Inject constructor(
    private val getSearchBookUseCase: GetSearchBookUseCase
) : BaseViewModel<SearchBookViewState, SearchBookViewSideEffect, SearchBookViewEvent>(
    SearchBookViewState()
) {

    private var loadJob: Job? = null

    private val inputQuery = MutableStateFlow(currentViewState.query)

    init {
        inputQuery
            .onEach { query ->
                updateState {
                    copy(
                        query = query,
                    )
                }
            }
            .flowOn(Dispatchers.Main.immediate)
            .debounce(300L)
            .onEach { query ->
                if (query.isEmpty()) {
                    updateState {
                        SearchBookViewState()
                    }
                } else {
                    getSearchBookPageInfo(true)
                }
            }
            .launchIn(viewModelScope)
    }

    override fun handleViewEvent(viewEvent: SearchBookViewEvent) {
        when (viewEvent) {
            is SearchBookViewEvent.OnTextChanged -> {
                onTextChanged(viewEvent.text)
            }
            is SearchBookViewEvent.OnClickBook -> {
                onClickBook(viewEvent.book)
            }
        }
    }

    private fun onTextChanged(text: String) {
        inputQuery.value = text
    }

    private fun onClickBook(book: Book) {
        book.isbn13?.takeIf { it.isNotEmpty() }?.let {
            sendSideEffect(SearchBookViewSideEffect.MoveToDetailBook(it))
        } ?: kotlin.run {
            sendSideEffect(SearchBookViewSideEffect.ShowToast(R.string.isbn13_not_valid_message))
        }
    }

    private fun getSearchBookPageInfo(isRefresh: Boolean = true) {
        loadJob?.cancel()
        loadJob = viewModelScope.launch {
            updateState {
                copy(
                    isLoading = isRefresh,
                    isMoreLoading = isRefresh.not(),
                    error = null,
                    page = if (isRefresh) {
                        INITIAL_PAGE_INDEX
                    } else {
                        page
                    }
                )
            }

            try {
                val resultBookInfo = getSearchBookUseCase(
                    SearchBookInput(
                        query = currentViewState.query.orEmpty(),
                        page = currentViewState.page
                    )
                )

                updateState {
                    copy(
                        isLoading = false,
                        isMoreLoading = false,
                        bookList = if (isRefresh) {
                            resultBookInfo.bookList
                        } else {
                            bookList.toMutableList().apply {
                                addAll(resultBookInfo.bookList)
                            }
                        },
                        page = page + INCREASE_PER_PAGE
                    )
                }
            } catch (e: Throwable) {
                e.printStackTrace()

                var error: Throwable? = e

                if (e is CancellationException || isRefresh.not()) {
                    error = null
                }

                updateState {
                    copy(
                        isLoading = false,
                        isMoreLoading = false,
                        error = error,
                    )
                }
            }
        }
    }
}