package com.syapp.bookapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.syapp.bookapp.navigation.graph.detailBook
import com.syapp.bookapp.navigation.graph.searchBook

@Composable
fun BookAppNavHost(
    navHostController: NavHostController,
    modifier: Modifier
) {
    NavHost(
        navController = navHostController,
        startDestination = Destination.SearchBookScreen.route,
        modifier = modifier,
    ) {
        searchBook(navHostController)
        detailBook(navHostController)
    }
}