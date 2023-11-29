package com.syapp.bookapp.search_book.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.syapp.bookapp.core.ui.AppThemeWithSurface
import com.syapp.bookapp.domain.model.Book

private const val LOAD_MORE_THRESHOLD = 5

@Composable
fun SearchBookContent(
    bookList: List<Book>,
    isMoreLoading: Boolean,
    onClickBook: (Book) -> Unit,
    onLoadMore: () -> Unit,
    modifier: Modifier,
) {
    val lazyListState = rememberLazyListState()

    val shouldMoreMore by remember {
        derivedStateOf {
            with(lazyListState.layoutInfo) {
                totalItemsCount > LOAD_MORE_THRESHOLD
                        && visibleItemsInfo.last().index + LOAD_MORE_THRESHOLD >= totalItemsCount
            }
        }
    }

    LaunchedEffect(key1 = shouldMoreMore) {
        if (shouldMoreMore) {
            onLoadMore.invoke()
        }
    }

    LazyColumn(
        state = lazyListState,
        modifier = modifier.fillMaxSize()
    ) {
        items(bookList) { book ->
            SearchBookItem(book = book, onClickBook = onClickBook)
        }

        if (isMoreLoading) {
            item {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp)
                ) {
                    CircularProgressIndicator()
                }
            }
        }
    }
}

@Preview
@Composable
fun SearchBookContentPreview() {
    AppThemeWithSurface {
        SearchBookContent(
            bookList = (0..20).map {
               Book(
                   image = null,
                   isbn13 = null,
                   price = null,
                   subtitle = "부제목 $it",
                   title = "제목 $it",
                   url = null,
               )
            },
            isMoreLoading = true,
            onClickBook = {},
            onLoadMore = {},
            modifier = Modifier.fillMaxSize()
        )
    }
}