package com.example.investment_kmm.common.data.model

import io.ktor.http.HttpStatusCode
import kotlinx.serialization.Serializable

@Serializable
data class EndOfDayObject (
    val date: String,
    val open: Float,
    val high: Float,
    val low: Float,
    val close: Float,
    val volume: Int,
    val adjOpen: Float,
    val adjHigh: Float,
    val adjLow: Float,
    val adjClose: Float,
    val adjVolume: Int,
    val divCash: Float,
    val splitFactor: Float
)

internal data class EndOfDayResponse(
    val code: HttpStatusCode,
    val data: List<EndOfDayObject> = listOf(),
)