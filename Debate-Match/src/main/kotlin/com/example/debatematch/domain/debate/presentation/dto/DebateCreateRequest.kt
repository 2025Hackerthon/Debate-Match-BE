package com.example.debatematch.domain.debate.presentation.dto

import com.example.debatematch.domain.debate.enum.DebateSide
import com.example.debatematch.domain.debatetag.enum.SubjectTag

data class DebateCreateRequest(
    val tagList: List<SubjectTag>,
    val title: String,
    val side: DebateSide,
)
