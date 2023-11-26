package com.syapp.bookapp.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DetailBook(
    @SerialName("authors")
    val authors: String?,
    @SerialName("desc")
    val desc: String?,
    @SerialName("image")
    val image: String?,
    @SerialName("isbn13")
    val isbn13: String?,
    @SerialName("language")
    val language: String?,
    @SerialName("pages")
    val pages: String?,
    @SerialName("price")
    val price: String?,
    @SerialName("publisher")
    val publisher: String?,
    @SerialName("rating")
    val rating: String?,
    @SerialName("subtitle")
    val subtitle: String?,
    @SerialName("title")
    val title: String?,
    @SerialName("url")
    val url: String?,
    @SerialName("year")
    val year: String?,
)