package com.syapp.bookapp.search_book.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.syapp.bookapp.core.ui.AppThemeWithSurface
import com.syapp.bookapp.core.util.textDp
import com.syapp.bookapp.domain.model.Book
import com.syapp.bookapp.search_book.R

@Composable
fun SearchBookItem(
    book: Book,
    onClickBook: (Book) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClickBook.invoke(book) }
            .padding(16.dp)
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(book.image)
                .placeholder(R.drawable.search_book_item_image_place_holder)
                .error(R.drawable.search_book_item_image_place_holder)
                .build(),
            contentScale = ContentScale.Crop,
            contentDescription = "",
            modifier = Modifier
                .clip(RoundedCornerShape(dimensionResource(id = R.dimen.search_book_item_image_radius)))
                .size(dimensionResource(id = R.dimen.search_book_item_image_size))
        )

        Spacer(modifier = Modifier.size(10.dp))

        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = book.title.orEmpty(),
                fontSize = 18.textDp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.size(3.dp))

            Text(
                text = book.subtitle.orEmpty(),
                fontSize = 14.textDp,
                fontWeight = FontWeight.Normal,
                color = Color.Gray,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Preview
@Composable
fun SearchBookItemPreview() {
    AppThemeWithSurface {
        SearchBookItem(
            book = Book(
                image = null,
                isbn13 = null,
                price = null,
                subtitle = "부제목",
                title = "제목",
                url = null
            ),
            onClickBook = {}
        )
    }
}