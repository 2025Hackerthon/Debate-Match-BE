package com.example.debatematch.global.security.jwt.exception

import com.example.debatematch.global.error.exception.CustomException
import com.example.debatematch.global.error.exception.ErrorCode

object InvaildJwtException: CustomException(
    ErrorCode.INVALID_TOKEN
) {
}