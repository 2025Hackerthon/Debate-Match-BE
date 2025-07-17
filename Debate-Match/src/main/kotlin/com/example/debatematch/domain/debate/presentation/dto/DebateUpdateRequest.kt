package com.example.debatematch.domain.debate.presentation.dto

import com.example.debatematch.domain.debate.enum.DebateLevel
import com.example.debatematch.domain.debate.enum.DebateSide
import java.util.UUID

data class DebateUpdateRequest(
    val level: DebateLevel,
    val content: String,
    val debateId: UUID,
    val side: DebateSide
)
