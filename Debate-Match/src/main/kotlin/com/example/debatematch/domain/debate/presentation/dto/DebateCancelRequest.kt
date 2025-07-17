package com.example.debatematch.domain.debate.presentation.dto

import com.example.debatematch.domain.debate.enum.DebateLevel
import com.example.debatematch.domain.debate.enum.DebateSide

data class DebateCancelRequest(
    val side: DebateSide,
    val level: DebateLevel
)
