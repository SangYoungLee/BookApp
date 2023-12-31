package com.syapp.bookapp.data.data_source

import com.syapp.bookapp.data.response.DetailBookResponse
import com.syapp.bookapp.data.response.SearchedBookResponse
import com.syapp.bookapp.data.url.UrlConfig
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import javax.inject.Inject

internal class RemoteBookDataSource @Inject constructor(
    private val httpClient: HttpClient,
) : BookDataSource {

    override suspend fun getSearchBookList(query: String, page: Int): SearchedBookResponse {
        return httpClient.get("${UrlConfig.BASE_URL}/search/$query/$page").body()
    }

    override suspend fun getDetailBook(isbn13: String): DetailBookResponse {
        return httpClient.get("${UrlConfig.BASE_URL}/books/$isbn13").body()
    }
}