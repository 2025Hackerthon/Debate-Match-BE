package com.example.debatematch.domain.debate.presentation.dto

import com.example.debatematch.domain.debate.enum.DebateSide
import com.example.debatematch.domain.debatetag.enum.SubjectTag
import java.util.*

data class DebateDoneMyQueryAllResponse(
    val title: String,
    val debateId: UUID,
    val tags: List<SubjectTag>,
    val side: DebateSide,
    val con: Int,
    val pro: Int
)
