package com.syapp.bookapp.search_book.ui

import android.widget.Toast
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.syapp.bookapp.core.ui.ErrorScreen
import com.syapp.bookapp.core.ui.LoadingScreen
import com.syapp.bookapp.core.util.rememberLambda
import com.syapp.bookapp.domain.model.state.ActionState
import com.syapp.bookapp.search_book.SearchBookContract.SearchBookViewEvent.OnClickBook
import com.syapp.bookapp.search_book.SearchBookContract.SearchBookViewEvent.OnLoadMore
import com.syapp.bookapp.search_book.SearchBookContract.SearchBookViewEvent.OnTextChanged
import com.syapp.bookapp.search_book.SearchBookContract.SearchBookViewSideEffect.MoveToDetailBook
import com.syapp.bookapp.search_book.SearchBookContract.SearchBookViewSideEffect.ShowToast
import com.syapp.bookapp.search_book.SearchBookViewModel

@Composable
fun SearchBookScreen(
    viewModel: SearchBookViewModel = hiltViewModel(),
    navigateToDetailBook: (String) -> Unit = {},
) {
    val viewState by viewModel.viewState.collectAsState()
    val context = LocalContext.current

    LaunchedEffect(key1 = viewModel.sideEffect) {
        viewModel.sideEffect.collect {
            when (it) {
                is MoveToDetailBook -> {
                    navigateToDetailBook.invoke(it.isbn13)
                }
                is ShowToast -> {
                    Toast.makeText(context, context.getString(it.messageResId), Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    Scaffold(
        topBar = {
            SearchBookAppBar(text = viewState.query, onTextChanged = rememberLambda(key1 = viewModel) { text ->
                viewModel.setViewEvent(OnTextChanged(text))
            })
        }
    ) { paddingValues ->
        if (viewState.actionState.isContentLoading) {
            LoadingScreen()
        } else if (viewState.actionState.isError) {
            ErrorScreen(throwable = (viewState.actionState as? ActionState.Error)?.cause)
        } else {
            SearchBookContent(
                bookList = viewState.bookList,
                isMoreLoading = viewState.actionState.isMoreLoading,
                onClickBook = rememberLambda(key1 = viewModel) { book ->
                    viewModel.setViewEvent(OnClickBook(book))
                },
                onLoadMore = rememberLambda<Unit>(key1 = viewModel) {
                    viewModel.setViewEvent(OnLoadMore)
                },
                modifier = Modifier.padding(bottom = paddingValues.calculateBottomPadding())
            )
        }
    }
}