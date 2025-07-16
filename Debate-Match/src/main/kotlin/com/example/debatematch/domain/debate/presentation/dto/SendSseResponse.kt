package com.example.debatematch.domain.debate.presentation.dto

import com.example.debatematch.domain.debate.enum.DebateLevel
import com.example.debatematch.domain.debate.enum.DebateSide

data class SendSseResponse(
    val level: DebateLevel,
    val content: String,
    val side: DebateSide,
)
