package com.syapp.bookapp.navigation

sealed class Destination(val route: String) {

    object SearchBookScreen : Destination("search_book")

    object DetailBookScreen : Destination("detail_book")
}