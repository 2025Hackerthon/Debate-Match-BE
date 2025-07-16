package com.example.debatematch.domain.debate.presentation.dto

import com.example.debatematch.domain.debatetag.enum.SubjectTag
import java.util.UUID

data class DebateDoneQueryAllResponse(
    val title: String,
    val debateId: UUID,
    val tags: List<SubjectTag>,
    val con: Int,
    val pro: Int
)
