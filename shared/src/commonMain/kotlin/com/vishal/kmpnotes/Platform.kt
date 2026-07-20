package com.vishal.kmpnotes

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform