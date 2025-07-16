package com.example.debatematch.domain.reaction.presentation.dto

import com.example.debatematch.domain.debate.enum.DebateSide
import java.util.UUID

data class ReactionRequest(
    val reaction: DebateSide,
    val debateId: UUID,
)
