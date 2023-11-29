package com.syapp.bookapp.core.ui

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import com.syapp.bookapp.core.ui.theme.BookAppTheme

@Composable
fun AppThemeWithSurface(content: @Composable () -> Unit) {
    BookAppTheme {
        Surface(color = MaterialTheme.colors.surface) {
            content()
        }
    }
}