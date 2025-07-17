package com.example.debatematch.domain.user.presentation.dto

import com.example.debatematch.domain.user.enum.EducationLevel

data class UserQueryInfoResponse(
    val educationLevel: EducationLevel,
    val username: String
)
