package com.example.debatematch.domain.debate.presentation.dto

import com.example.debatematch.domain.debate.enum.DebateSide
import com.example.debatematch.domain.debatetag.enum.SubjectTag
import java.util.UUID

data class DebateQueryResponse(
    val debateId: UUID,
    val title: String,
    val side: DebateSide,
    val tags: List<SubjectTag>
)
