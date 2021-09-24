package com.ajcm.domain.usecase

import com.ajcm.domain.entities.BestSeller
import com.ajcm.domain.repository.IBookRepository
import javax.inject.Inject

class GetBestSellersUC @Inject constructor(private val bookRepository: IBookRepository) {
    suspend operator fun invoke(): List<BestSeller> = bookRepository.getBestSellers()
}
