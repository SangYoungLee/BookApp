package com.syapp.bookapp.detail_book.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.syapp.bookapp.core.ui.AppThemeWithSurface
import com.syapp.bookapp.core.ui.theme.Color_EEEEEE
import com.syapp.bookapp.core.util.textDp

@Composable
fun DetailBookMenuItem(
    imageVector: ImageVector,
    label: String,
    text: String,
    textMaxLines: Int = Int.MAX_VALUE
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 3.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(imageVector = imageVector, contentDescription = "")

            Spacer(modifier = Modifier.size(5.dp))

            Text(
                text = label,
                fontWeight = FontWeight.Bold,
                fontSize = 16.textDp
            )

            Spacer(modifier = Modifier.size(12.dp))

            Text(
                text = text,
                fontWeight = FontWeight.Medium,
                fontSize = 16.textDp,
                maxLines = textMaxLines,
                overflow = TextOverflow.Ellipsis
            )
        }

        Divider(color = Color_EEEEEE)
    }
}

@Preview
@Composable
fun DetailBookMenuItemPreview() {
    AppThemeWithSurface {
        DetailBookMenuItem(
            imageVector = Icons.Default.Info,
            label = "설명",
            text = "책 설명 입니다. 123123"
        )
    }
}