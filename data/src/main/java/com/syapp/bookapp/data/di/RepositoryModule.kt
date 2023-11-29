package com.syapp.bookapp.data.di

import com.syapp.bookapp.data.repository.BookRepositoryImpl
import com.syapp.bookapp.domain.repository.BookRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface RepositoryModule {

    @Binds
    fun bindBookRepository(
        bookRepository: BookRepositoryImpl
    ): BookRepository
}