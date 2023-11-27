package com.syapp.bookapp.search_book.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
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

    Scaffold(
        topBar = {
            SearchBookAppBar(text = viewState.query, onTextChanged = rememberLambda(key1 = viewModel) { text ->
                viewModel.setViewEvent(OnTextChanged(text))
            })
        }
    ) { paddingValues ->
        if (viewState.isLoading) {
            LoadingScreen()
        } else if (viewState.hasError) {
            ErrorScreen(throwable = viewState.error)
        } else {
            SearchBookContent(
                bookList = viewState.bookList,
                modifier = Modifier.padding(bottom = paddingValues.calculateBottomPadding())
            )
        }
    }
}