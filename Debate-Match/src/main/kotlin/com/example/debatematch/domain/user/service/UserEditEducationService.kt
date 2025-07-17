package com.example.debatematch.domain.user.service

import com.example.debatematch.domain.user.facade.UserFacade
import com.example.debatematch.domain.user.presentation.dto.UserEditEducationRequest
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserEditEducationService(
    private val userFacade: UserFacade
) {
    @Transactional
    fun execute(request: UserEditEducationRequest) {
        val user = userFacade.currentUser()

        user.educationLevel = request.educationLevel
    }
}