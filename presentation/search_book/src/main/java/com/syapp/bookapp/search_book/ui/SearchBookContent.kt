package com.syapp.bookapp.search_book.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.syapp.bookapp.domain.model.Book

@Composable
fun SearchBookContent(
    bookList: List<Book>,
    onClickBook: (Book) -> Unit,
    modifier: Modifier,
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(bookList) { book ->
            SearchBookItem(book = book, onClickBook = onClickBook)
        }
    }
}