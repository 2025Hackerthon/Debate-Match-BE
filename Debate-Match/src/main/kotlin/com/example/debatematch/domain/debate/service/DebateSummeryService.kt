package com.example.debatematch.domain.debate.service

import com.example.debatematch.domain.argument.persistence.ArgumentRepository
import com.example.debatematch.domain.debate.enum.DebateSide
import com.example.debatematch.domain.debate.persistence.DebateRepository
import com.example.debatematch.domain.gemini.client.GeminiFeignClient
import com.example.debatematch.domain.gemini.domain.DebateSummaryResponse
import com.example.debatematch.domain.gemini.domain.GeminiContent
import com.example.debatematch.domain.gemini.domain.GeminiPart
import com.example.debatematch.domain.gemini.domain.GeminiRequest
import com.example.debatematch.domain.gemini.prompt.Prompt
import com.example.debatematch.domain.participated.persistence.ParticipatedRepository
import kotlinx.serialization.json.Json
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class DebateSummeryService(
    private val geminiFeignClient: GeminiFeignClient,
    private val argumentRepository: ArgumentRepository,
    @Value("\${gemini.api-key}") val geminiApiKey: String,
    private val participatedRepository: ParticipatedRepository,
    private val debateRepository: DebateRepository
) {
    companion object {
        val prompt = Prompt()
    }

    @Transactional
    fun execute(debateId: UUID) {
        val arguments = argumentRepository.findAllByDebateId(debateId)

        println(prompt.prompt + arguments.map { it.side.side + "측 " + it.level.value + it.content })
        println(geminiApiKey)

        val response = geminiFeignClient.generateContent(
            apiKey = geminiApiKey,
            request = GeminiRequest(
                contents = listOf(
                    GeminiContent(
                        parts = listOf(
                            GeminiPart(text = prompt.prompt + arguments.map { it.side.side + "측 " + it.level.value + it.content })
                        )
                    )
                )
            )
        )

        val debateSummary = Json.decodeFromString<DebateSummaryResponse>(response.candidates[0].content.parts[0].text)
        println(response)

        val participated = participatedRepository.findAllByDebateId(debateId)
        participated.map { it.feedback = if (it.side == DebateSide.PRO) debateSummary.feedback!!.agree else debateSummary.feedback!!.disagree }

        var debate = debateRepository.findById(debateId).orElseThrow()
        debate.summary = debateSummary.summary
    }
}
