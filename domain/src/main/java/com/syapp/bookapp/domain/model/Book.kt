package com.syapp.bookapp.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Book(
    @SerialName("image")
    val image: String?,
    @SerialName("isbn13")
    val isbn13: String?,
    @SerialName("price")
    val price: String?,
    @SerialName("subtitle")
    val subtitle: String?,
    @SerialName("title")
    val title: String?,
    @SerialName("url")
    val url: String?,
)