package com.example.debatematch.domain.debate.exception

import com.example.debatematch.global.error.exception.CustomException
import com.example.debatematch.global.error.exception.ErrorCode

object DebateNotInProgressException : CustomException(
    ErrorCode.DEBATE_NOT_IN_PROGRESS
)
