package com.example.debatematch.domain.sse.exception

import com.example.debatematch.global.error.exception.CustomException
import com.example.debatematch.global.error.exception.ErrorCode

object SseEmitterAlreadyCompletedException : CustomException(
    ErrorCode.SseEmitterAlreadyCompletedException
){
}