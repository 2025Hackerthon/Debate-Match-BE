package com.example.debatematch.domain.user.presentation.dto

import com.example.debatematch.domain.user.enum.EducationLevel

data class UserSignUpRequest(
    val accountId: String,
    val password: String,
    val educationLevel: EducationLevel,
)
