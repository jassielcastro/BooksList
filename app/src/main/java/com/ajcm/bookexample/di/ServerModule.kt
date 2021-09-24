package com.ajcm.bookexample.di

import com.ajcm.bookexample.datasource.RemoteDataSource
import com.ajcm.data.BookRepository
import com.ajcm.data.datasource.IRemoteBooksDataSource
import com.ajcm.domain.repository.IBookRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class ServerModule {

    @Binds
    abstract fun bindRemoteBookDataSource(remoteBookDatasource: RemoteDataSource): IRemoteBooksDataSource

    @Binds
    abstract fun bindBookRepository(repository: BookRepository): IBookRepository

}
