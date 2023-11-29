package com.syapp.bookapp.navigation.graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.syapp.bookapp.navigation.Destination
import com.syapp.bookapp.search_book.ui.SearchBookScreen

fun NavGraphBuilder.searchBook(navController: NavController) {
    composable(
        route = Destination.SearchBookScreen.route
    ) {
        SearchBookScreen(
            navigateToDetailBook = { isbn13 ->
                navController.navigate("${Destination.DetailBookScreen.route}/$isbn13")
            }
        )
    }
}