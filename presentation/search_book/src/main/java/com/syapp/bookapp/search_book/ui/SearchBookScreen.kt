package com.syapp.bookapp.search_book.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.syapp.bookapp.core.ui.ErrorScreen
import com.syapp.bookapp.core.ui.LoadingScreen
import com.syapp.bookapp.core.util.rememberLambda
import com.syapp.bookapp.search_book.SearchBookContract.SearchBookViewEvent.OnTextChanged
import com.syapp.bookapp.search_book.SearchBookViewModel

@Composable
fun SearchBookScreen(
    viewModel: SearchBookViewModel = hiltViewModel(),
) {
    val viewState by viewModel.viewState.collectAsState()

    if (viewState.isLoading) {
        LoadingScreen()
    } else if (viewState.hasError) {
        ErrorScreen(throwable = viewState.error)
    } else {
        SearchBookContent(
            text = viewState.query,
            onTextChanged = rememberLambda(key1 = viewModel) { text ->
                viewModel.setViewEvent(OnTextChanged(text))
            },
            bookList = viewState.bookList,
        )
    }
}