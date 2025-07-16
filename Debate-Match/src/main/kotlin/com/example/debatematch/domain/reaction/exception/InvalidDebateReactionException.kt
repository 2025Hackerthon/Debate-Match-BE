package com.example.debatematch.domain.reaction.exception

import com.example.debatematch.global.error.exception.CustomException
import com.example.debatematch.global.error.exception.ErrorCode

object InvalidDebateReactionException: CustomException(
    ErrorCode.INVALID_DEBATE_REACTION,
) {
}