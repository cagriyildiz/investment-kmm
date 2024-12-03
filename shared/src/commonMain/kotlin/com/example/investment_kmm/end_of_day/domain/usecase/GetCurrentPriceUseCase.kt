package com.example.investment_kmm.end_of_day.domain.usecase

import com.example.investment_kmm.common.data.model.EndOfDayObject
import com.example.investment_kmm.common.util.Result
import com.example.investment_kmm.end_of_day.domain.repository.EndOfDayRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetCurrentPriceUseCase : KoinComponent {
    val repository by inject<EndOfDayRepository>()

    suspend operator fun invoke(ticker: String) : Result<List<EndOfDayObject>> {
        return repository.currentPrice(ticker)
    }
}