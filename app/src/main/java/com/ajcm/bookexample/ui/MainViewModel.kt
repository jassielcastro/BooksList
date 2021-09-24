package com.ajcm.bookexample.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ajcm.domain.entities.Book
import com.ajcm.domain.usecase.GetBestSellersUC
import com.ajcm.domain.usecase.GetBooksUC
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getBooksUC: GetBooksUC,
    private val getBestSellersUC: GetBestSellersUC
) : ViewModel() {

    private val _model = MutableLiveData<UiModel>()
    val model: LiveData<UiModel>
        get() {
            if (_model.value == null) refresh()
            return _model
        }

    fun refresh() {
        _model.value = UiModel.Loading

        CoroutineScope(Dispatchers.IO).launch {
            runCatching {
                val booksSections = mutableListOf<BooksSections>()
                val bestSellers = getBestSellersUC()
                booksSections.add(BooksSections(Section.BEST_SELLER, bestSellers))

                val books = getBooksUC()

                booksSections.add(BooksSections(Section.HISTORY, books.filter { it.genre == "History" }))
                booksSections.add(BooksSections(Section.SCIENCE, books.filter { it.genre == "Science" }))
                booksSections.add(BooksSections(Section.BUSINESS, books.filter { it.genre == "Business" }))
                booksSections
            }.onSuccess {
                _model.value = UiModel.Content(it)
            }.onFailure {
                _model.value = UiModel.ShowError
            }
        }

    }

}
