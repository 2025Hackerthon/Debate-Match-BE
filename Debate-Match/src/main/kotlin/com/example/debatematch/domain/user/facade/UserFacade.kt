package com.example.debatematch.domain.user.facade

import com.example.debatematch.domain.debate.enum.DebateStatus
import com.example.debatematch.domain.debate.exception.PlayingUserException
import com.example.debatematch.domain.debate.persistence.DebateRepository
import com.example.debatematch.domain.participated.persistence.ParticipatedRepository
import com.example.debatematch.domain.user.User
import com.example.debatematch.domain.user.exception.UserNotFoundException
import com.example.debatematch.domain.user.persistence.UserRepository
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component

@Component
class UserFacade(
    private val userRepository: UserRepository,
    private val participatedRepository: ParticipatedRepository,
    private val debateRepository: DebateRepository
) {
    fun currentUser(): User {
        val accountId = SecurityContextHolder.getContext().authentication.name
        return userRepository.findByAccountId(accountId) ?: throw UserNotFoundException
    }

    fun currentUserOrNull(): User? {
        val accountId = SecurityContextHolder.getContext().authentication.name
        return userRepository.findByAccountId(accountId)
    }

    fun getUserByAccountIdOrThrow(accountId: String): User {
        return userRepository.findByAccountId(accountId) ?: throw UserNotFoundException
    }

    fun checkUser() {
        val user = currentUser()
        val debateIds = participatedRepository.findAllByUserId(user.id!!).map { it.debateId}
        debateIds.map { if(debateRepository.existsByIdAndStatus(it, DebateStatus.WAIT) ||  debateRepository.existsByIdAndStatus(it, DebateStatus.PLAY)) throw PlayingUserException}
    }
}
