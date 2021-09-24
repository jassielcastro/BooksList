package com.ajcm.bookexample.di

import com.ajcm.bookexample.ui.MainViewModel
import com.ajcm.domain.usecase.GetBestSellersUC
import com.ajcm.domain.usecase.GetBooksUC
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
class ViewModelModule {

    @Provides
    fun provideViewModel(booksUC: GetBooksUC, bestSellersUC: GetBestSellersUC): MainViewModel {
        return MainViewModel(booksUC, bestSellersUC)
    }

}
