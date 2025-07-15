package com.example.debatematch.domain.user.service

import com.example.debatematch.domain.user.User
import com.example.debatematch.domain.user.exception.UserAccountIdDuplicationException
import com.example.debatematch.domain.user.persistence.UserRepository
import com.example.debatematch.domain.user.presentation.dto.UserSignUpRequest
import jakarta.transaction.Transactional
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class UserSignUpService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder
) {
    @Transactional
    fun execute(request: UserSignUpRequest): UUID?{
        if(userRepository.existsUserByAccountId(request.accountId)){
            throw UserAccountIdDuplicationException
        }

        return userRepository.save(User(
            accountId = request.accountId,
            password = passwordEncoder.encode(request.password),
            educationLevel = request.educationLevel
        )).id
    }
}