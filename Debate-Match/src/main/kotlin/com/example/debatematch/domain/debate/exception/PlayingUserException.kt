package com.example.debatematch.domain.debate.exception

import com.example.debatematch.global.error.exception.CustomException
import com.example.debatematch.global.error.exception.ErrorCode

object PlayingUserException:CustomException(
    ErrorCode.PLAYER_ALREADY_OWNED
){
}