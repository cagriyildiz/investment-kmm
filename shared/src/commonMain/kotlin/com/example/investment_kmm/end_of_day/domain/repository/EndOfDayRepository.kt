package com.example.investment_kmm.end_of_day.domain.repository

import com.example.investment_kmm.common.data.model.EndOfDayObject
import com.example.investment_kmm.common.util.Result

interface EndOfDayRepository {
    suspend fun currentPrice(ticker: String): Result<List<EndOfDayObject>>
}