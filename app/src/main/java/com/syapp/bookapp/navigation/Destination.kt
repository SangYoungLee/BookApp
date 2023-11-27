package com.syapp.bookapp.navigation

import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.syapp.bookapp.detail_book.contracts.DetailBookContract

sealed class Destination(val route: String) {

    object SearchBookScreen : Destination("search_book")

    object DetailBookScreen : Destination("detail_book") {
        val routeWithArgs = "$route/{${DetailBookContract.KEY_REQUEST_ID}}"
        val arguments = listOf(
            navArgument(DetailBookContract.KEY_REQUEST_ID) { type = NavType.StringType}
        )
    }
}