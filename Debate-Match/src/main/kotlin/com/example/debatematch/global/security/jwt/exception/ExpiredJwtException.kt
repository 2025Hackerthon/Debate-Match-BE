package com.example.debatematch.global.security.jwt.exception

import com.example.debatematch.global.error.exception.CustomException
import com.example.debatematch.global.error.exception.ErrorCode

object ExpiredJwtException : CustomException(
    ErrorCode.EXPIRED_TOKEN,
)
