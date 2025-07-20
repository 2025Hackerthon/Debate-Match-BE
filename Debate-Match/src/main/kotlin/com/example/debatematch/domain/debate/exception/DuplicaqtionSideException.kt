package com.example.debatematch.domain.debate.exception

import ch.qos.logback.core.spi.ErrorCodes
import com.example.debatematch.global.error.exception.CustomException
import com.example.debatematch.global.error.exception.ErrorCode

object DuplicaqtionSideException:CustomException(
    ErrorCode.DUPLICA_EXCEPTION,
) {
}