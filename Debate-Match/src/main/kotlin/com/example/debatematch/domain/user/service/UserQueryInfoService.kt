package com.example.debatematch.domain.user.service

import com.example.debatematch.domain.user.facade.UserFacade
import com.example.debatematch.domain.user.presentation.dto.UserQueryInfoResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserQueryInfoService(
    private val userFacade: UserFacade
) {
    @Transactional(readOnly = true)
    fun execute(): UserQueryInfoResponse{
        val user = userFacade.currentUser()

        return UserQueryInfoResponse(educationLevel = user.educationLevel, username = user.accountId)
    }
}