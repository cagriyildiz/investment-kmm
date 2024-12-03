package com.example.investment_kmm.android.di

import com.example.investment_kmm.android.MainActivityViewModel
import org.koin.dsl.module

val appModule = module {
    single { MainActivityViewModel(get()) }
}