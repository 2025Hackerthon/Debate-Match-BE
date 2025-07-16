package com.example.debatematch.domain.debate.presentation.dto

import com.example.debatematch.domain.debate.enum.DebateLevel
import com.example.debatematch.domain.debate.enum.DebateSide

data class DebateDoneQueryResponse(
    val summary: String?,
    val feedback: String?,
    val data: List<Argument>
)
data class Argument(
    val level: DebateLevel,
    val content: String,
    val side: DebateSide
)

