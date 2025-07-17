package com.example.debatematch.domain.gemini.domain

import kotlinx.serialization.Serializable
@Serializable
data class OuterWrapper(val text: String)

@Serializable
data class GeminiResponse(
    val candidates: List<Candidate>,
    val usageMetadata: UsageMetadata,
    val modelVersion: String,
    val responseId: String
)

@Serializable
data class Candidate(
    val content: Content,
    val finishReason: String,
    val index: Int
)

@Serializable
data class Content(
    val parts: List<Part>,
    val role: String
)

@Serializable
data class Part(
    val text: String
)

@Serializable
data class UsageMetadata(
    val promptTokenCount: Int,
    val candidatesTokenCount: Int,
    val totalTokenCount: Int,
    val promptTokensDetails: List<PromptTokensDetail>,
    val thoughtsTokenCount: Int
)

@Serializable
data class PromptTokensDetail(
    val modality: String,
    val tokenCount: Int
)

@Serializable
data class DebateSummaryResponse(
    val summary: String?,
    val feedback: Feedback?
)

/**
 * 피드백 상세 정보를 위한 도메인 모델
 */
@Serializable
data class Feedback(
    val agree: String?,
    val disagree: String?
)
