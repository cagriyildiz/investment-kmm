package com.example.investment_kmm.common.data.remote

import com.example.investment_kmm.common.data.model.EndOfDayResponse
import io.ktor.client.call.body
import io.ktor.client.request.get

internal class EndOfDayService: KtorApi() {

    suspend fun currentPrice(ticker: String): EndOfDayResponse {
        val httpResponse = client.get {
            endPoint(path = "tiingo/daily/$ticker/prices")
            setToken()
        }
        return EndOfDayResponse(code = httpResponse.status, data = httpResponse.body())
    }

}