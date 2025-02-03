package com.jedsolution.bookargo

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform