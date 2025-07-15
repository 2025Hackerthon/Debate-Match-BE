package com.example.debatematch.domain.user.service

import com.example.debatematch.domain.user.User
import com.example.debatematch.domain.user.exception.UserAccountIdDuplicationException
import com.example.debatematch.domain.user.persistence.UserRepository
import com.example.debatematch.domain.user.presentation.dto.UserSignUpRequest
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class UserSignUpService(
    private val userRepository: UserRepository,
) {
    @Transactional
    fun execute(request: UserSignUpRequest): UUID?{
        if(userRepository.existsUserByAccountId(request.accountId)){
            throw UserAccountIdDuplicationException
        }

        return userRepository.save(User(
            accountId = request.accountId,
            password = request.password,
            educationLevel = request.educationLevel
        )).id
    }
}