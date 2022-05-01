package com.demo.data

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json


fun createHttpClient() = HttpClient(CIO) {
    install(ContentNegotiation) {
        json(Json)
    }
    install(Logging) {
        logger = Logger.DEFAULT
        level = LogLevel.INFO
    }
    defaultRequest {
        parametersOf("api_key", "392769cae8cb43b9e9b953eb0cec86bf")
    }
}