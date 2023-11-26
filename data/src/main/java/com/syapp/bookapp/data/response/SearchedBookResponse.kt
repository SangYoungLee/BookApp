package com.syapp.bookapp.data.response

import com.syapp.bookapp.domain.model.Book
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class SearchedBookResponse(
    @SerialName("books")
    val books: List<Book>,
    @SerialName("error")
    val error: String,
    @SerialName("page")
    val page: String,
    @SerialName("total")
    val total: String
)