package com.example.investment_kmm.android

import android.app.Application
import com.example.investment_kmm.android.di.appModule
import com.example.investment_kmm.common.di.getSharedModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class InvestmentApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(appModule + getSharedModules())
            androidContext(this@InvestmentApplication)
        }
    }

}