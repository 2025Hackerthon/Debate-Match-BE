package com.example.debatematch.global.error.exception

abstract class CustomException(
    val errorCode: ErrorCode,
) : RuntimeException()
