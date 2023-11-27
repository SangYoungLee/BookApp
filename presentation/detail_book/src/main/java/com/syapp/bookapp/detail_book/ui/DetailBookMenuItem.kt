package com.syapp.bookapp.detail_book.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.syapp.bookapp.core.util.textDp

@Composable
fun DetailBookMenuItem(
    imageVector: ImageVector,
    label: String,
    text: String,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
            .padding(vertical = 3.dp)
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
            fontSize = 16.textDp
        )
    }
}