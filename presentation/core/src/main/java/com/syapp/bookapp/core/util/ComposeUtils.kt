package com.syapp.bookapp.core.util

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp

private fun Int.textDp(density: Density): TextUnit = with(density) {
    this@textDp.dp.toSp()
}

val Int.textDp: TextUnit
    @Composable get() =  this.textDp(density = LocalDensity.current)

@Composable
fun <I, O> rememberLambda(
    key1: Any?,
    lambda: (I) -> O
) = remember(key1) { lambda }

@Composable
fun <O> rememberLambda(
    key1: Any?,
    lambda: () -> O
) = remember(key1) { lambda }
