package com.syapp.bookapp.search_book.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.syapp.bookapp.domain.model.Book

@Composable
fun SearchBookContent(
    text: String,
    onTextChanged: (String) -> Unit,
    bookList: List<Book>
) {
    Scaffold(
        topBar = {
            SearchBookAppBar(text = text, onTextChanged = onTextChanged)
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier.padding(
                bottom = paddingValues.calculateBottomPadding()
            )
        ) {
            items(bookList) { book ->
                SearchBookItem(book = book)
            }
        }
    }
}