package com.example.debatematch.domain.user.presentation.dto

import com.example.debatematch.domain.user.enum.EducationLevel

data class UserEditEducationRequest (
    val educationLevel: EducationLevel
)