package com.example.debatematch.domain.debate.presentation.dto

import com.example.debatematch.domain.debate.enum.DebateSide

data class DebateJoinCancelRequest(
    val side: DebateSide
)
