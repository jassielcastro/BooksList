package com.ajcm.bookexample.di

import com.ajcm.bookexample.server.BookApi
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.ConnectionSpec
import okhttp3.OkHttpClient
import okhttp3.TlsVersion
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class BaseUrl

@Module
@InstallIn(SingletonComponent::class)
class ConfigurationModule {

    @BaseUrl
    @Provides
    fun provideBooksUrl(): String = "https://raw.githubusercontent.com/ejgteja"

    @Provides
    fun provideConnectionSpec(): ConnectionSpec {
        return ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS)
            .tlsVersions(TlsVersion.TLS_1_2)
            .build()
    }

    @Provides
    fun provideOkHttpClient(
        cs: ConnectionSpec
    ): OkHttpClient {
        val okhttp = OkHttpClient.Builder()
        okhttp.writeTimeout(30, TimeUnit.SECONDS)
        okhttp.readTimeout(30, TimeUnit.SECONDS)
        okhttp.connectionSpecs(listOf(cs))
        return okhttp.build()
    }

    @Provides
    fun provideRetrofit(@BaseUrl baseUrl: String, client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideApi(retrofit: Retrofit): BookApi {
        return retrofit.create(BookApi::class.java)
    }

}
