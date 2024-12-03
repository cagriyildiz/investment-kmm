package com.example.investment_kmm.common.di

import com.example.investment_kmm.common.data.remote.EndOfDayService
import com.example.investment_kmm.common.util.provideDispatcher
import com.example.investment_kmm.end_of_day.data.EndOfDayRepositoryImpl
import com.example.investment_kmm.end_of_day.domain.repository.EndOfDayRepository
import com.example.investment_kmm.end_of_day.domain.usecase.GetCurrentPriceUseCase
import org.koin.dsl.module

private val endOfDayModule = module {
    single<EndOfDayRepository> { EndOfDayRepositoryImpl(get(), get()) }
    factory { EndOfDayService() }
    factory { GetCurrentPriceUseCase() }
}

private val utilityModule = module {
    factory { provideDispatcher() }
}

fun getSharedModules() = listOf(
    endOfDayModule,
    utilityModule
)