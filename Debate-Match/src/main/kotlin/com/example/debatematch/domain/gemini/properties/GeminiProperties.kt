package com.example.debatematch.domain.gemini.properties

import org.springframework.beans.factory.annotation.Value

data class GeminiProperties(
    @Value("\${gemini.api-key}")
    val geminiApiKey: String
)
