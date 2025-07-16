package com.example.debatematch.domain.user.exception

import com.example.debatematch.global.error.exception.CustomException
import com.example.debatematch.global.error.exception.ErrorCode

object UserAccountIdDuplicationException : CustomException(
    ErrorCode.DUPLICATE_USER,
)
