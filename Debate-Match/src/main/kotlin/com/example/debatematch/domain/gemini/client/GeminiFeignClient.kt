package com.example.debatematch.domain.gemini.client

import com.example.debatematch.domain.gemini.domain.DebateSummaryResponse
import com.example.debatematch.domain.gemini.domain.GeminiRequest
import com.example.debatematch.domain.gemini.domain.GeminiResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(name = "neis-feign-client", url = "https://generativelanguage.googleapis.com/v1beta")
interface GeminiFeignClient {
    @PostMapping("/models/gemini-2.5-flash:generateContent")
    fun generateContent(
        @RequestParam("key") apiKey: String,
        @RequestBody request: GeminiRequest
    ): GeminiResponse

}