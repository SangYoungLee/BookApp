package com.syapp.bookapp.search_book.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.syapp.bookapp.core.ui.theme.Color_EEEEEE
import com.syapp.bookapp.core.util.textDp
import com.syapp.bookapp.search_book.R

@Composable
fun SearchBookAppBar(
    text: String,
    onTextChanged: (String) -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        TextField(
            leadingIcon = {
                Icon(imageVector = Icons.Default.Search, contentDescription = "")
            },
            trailingIcon = {
                IconButton(onClick = { onTextChanged.invoke("")} ) {
                    Icon(imageVector = Icons.Default.Clear, contentDescription = "")
                }
            },
            value = text,
            onValueChange = onTextChanged,
            placeholder = {
                Text(
                    text = stringResource(id = R.string.hint_query_input),
                    color = Color.Gray,
                    fontSize = 14.textDp
                )
            },
            maxLines = 1,
            modifier = Modifier.fillMaxWidth()
                .padding(10.dp)
                .background(color = Color_EEEEEE)
        )
    }
}