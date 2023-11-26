package com.syapp.bookapp.data

import com.syapp.bookapp.domain.Book
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class BookResponse(
    @SerialName("books")
    val books: List<Book>,
    @SerialName("error")
    val error: String,
    @SerialName("page")
    val page: String,
    @SerialName("total")
    val total: String
)