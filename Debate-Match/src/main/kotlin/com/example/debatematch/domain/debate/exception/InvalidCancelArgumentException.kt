package com.example.debatematch.domain.debate.exception

import com.example.debatematch.global.error.exception.CustomException
import com.example.debatematch.global.error.exception.ErrorCode

object InvalidCancelArgumentException: CustomException(
    ErrorCode.CANCEL_INPUT_ERROR,
) {
}