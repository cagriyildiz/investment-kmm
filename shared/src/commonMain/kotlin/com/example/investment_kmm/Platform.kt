package com.example.investment_kmm

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform