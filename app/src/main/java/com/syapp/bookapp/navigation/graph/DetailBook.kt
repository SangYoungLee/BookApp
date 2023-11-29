package com.syapp.bookapp.navigation.graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.syapp.bookapp.detail_book.ui.DetailBookScreen
import com.syapp.bookapp.navigation.Destination

fun NavGraphBuilder.detailBook(navController: NavController) {
    composable(
        route = Destination.DetailBookScreen.routeWithArgs
    ) {
        DetailBookScreen(
            navigateToBack = {
                navController.popBackStack()
            }
        )
    }
}