package com.example.investment_kmm.common.util

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

internal class NativeDispatcher : DispatcherProvider {
    override val io: CoroutineDispatcher
        get() = Dispatchers.Default
    override val main: CoroutineDispatcher
        get() = Dispatchers.Main
}

internal actual fun provideDispatcher(): DispatcherProvider = NativeDispatcher()