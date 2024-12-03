package com.example.investment_kmm.end_of_day.data

import com.example.investment_kmm.common.data.model.EndOfDayObject
import com.example.investment_kmm.common.data.remote.EndOfDayService
import com.example.investment_kmm.common.util.DispatcherProvider
import com.example.investment_kmm.common.util.Result
import com.example.investment_kmm.common.util.safeApiCall
import com.example.investment_kmm.end_of_day.domain.repository.EndOfDayRepository
import io.ktor.http.HttpStatusCode

internal class EndOfDayRepositoryImpl(
    private val dispatcher: DispatcherProvider,
    private val client: EndOfDayService
) : EndOfDayRepository {
    override suspend fun currentPrice(ticker: String): Result<List<EndOfDayObject>> {
        return safeApiCall(dispatcher) {
            val result = client.currentPrice(ticker)

            when (result.code) {
                HttpStatusCode.OK -> Result.Success(data = result.data)
                else -> Result.Error(message = "Error calling End-of-Day API")
            }
        }
    }
}