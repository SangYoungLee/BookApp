package com.syapp.bookapp.detail_book.ui

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
import com.syapp.bookapp.detail_book.contracts.DetailBookViewModel
import com.syapp.bookapp.domain.model.state.ActionState

@Composable
fun DetailBookScreen(
    viewModel: DetailBookViewModel = hiltViewModel(),
    navigateToBack: () -> Unit = {},
) {
    val viewState by viewModel.viewState.collectAsState()

    Scaffold(
        topBar = {
            DetailBookAppBar(onClickBack = rememberLambda<Unit>(key1 = viewModel) {
                navigateToBack.invoke()
            })
        }
    ) { paddingValues ->
        if (viewState.actionState.isContentLoading) {
            LoadingScreen()
        } else if (viewState.actionState.isError) {
            ErrorScreen(throwable = (viewState.actionState as? ActionState.Error)?.cause)
        } else {
            DetailBookContent(
                detailBook = viewState.detailBook ?: return@Scaffold,
                modifier = Modifier.padding(bottom = paddingValues.calculateBottomPadding())
            )
        }
    }
}