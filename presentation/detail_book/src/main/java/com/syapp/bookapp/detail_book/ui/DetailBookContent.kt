package com.syapp.bookapp.detail_book.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.syapp.bookapp.core.ui.AppThemeWithSurface
import com.syapp.bookapp.core.util.textDp
import com.syapp.bookapp.detail_book.R
import com.syapp.bookapp.domain.model.DetailBook

@Composable
fun DetailBookContent(
    detailBook: DetailBook,
    modifier: Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(16.dp)
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(detailBook.image)
                .placeholder(R.drawable.detail_book_image_place_holder)
                .error(R.drawable.detail_book_image_place_holder)
                .build(),
            contentScale = ContentScale.Crop,
            contentDescription = "",
            modifier = Modifier
                .clip(RoundedCornerShape(5.dp))
                .size(dimensionResource(id = R.dimen.detail_book_image_size))
        )

        Text(
            text = detailBook.title.orEmpty(),
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontSize = 24.textDp
        )

        Spacer(modifier = Modifier.size(5.dp))

        Text(
            text = detailBook.subtitle.orEmpty(),
            fontWeight = FontWeight.SemiBold,
            color = Color.Gray,
            fontSize = 20.textDp
        )

        Spacer(modifier = Modifier.size(10.dp))

        DetailBookMenuItem(
            imageVector = Icons.Default.Person,
            label = stringResource(id = R.string.authors),
            text = detailBook.authors.orEmpty()
        )

        DetailBookMenuItem(
            imageVector = Icons.Default.Info,
            label = stringResource(id = R.string.description),
            text = detailBook.desc.orEmpty(),
            textMaxLines = 3
        )
    }
}

@Preview
@Composable
fun DetailBookContentPreview() {
    AppThemeWithSurface {
        DetailBookContent(
            detailBook = DetailBook(
                authors = "작가1, 작가2",
                desc = "설명",
                image = "",
                language = null,
                pages = null,
                price = null,
                subtitle = "부제목",
                title = "제목",
                year = null
            ),
            modifier = Modifier.fillMaxSize()
        )
    }
}