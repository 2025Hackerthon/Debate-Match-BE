package com.example.debatematch.domain.user.service

import com.example.debatematch.domain.user.exception.UserDuplicationException
import com.example.debatematch.domain.user.persistence.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserCheckIdService(
    private val userRepository: UserRepository
) {
    @Transactional(readOnly = true)
    fun execute(accountId: String) {
        if(userRepository.existsByAccountId(accountId)){
            throw UserDuplicationException
        }
    }
}