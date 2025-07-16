package com.example.debatematch.domain.debate.presentation.dto

import com.example.debatematch.domain.debate.enum.DebateSide
import java.util.UUID

data class DebateJoinRequest(
    val debateId: UUID,
    val side: DebateSide
) {
}