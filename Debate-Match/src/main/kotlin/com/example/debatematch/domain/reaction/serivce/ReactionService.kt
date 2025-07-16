package com.example.debatematch.domain.reaction.serivce

import com.example.debatematch.domain.debate.enum.DebateStatus
import com.example.debatematch.domain.debate.persistence.DebateRepository
import com.example.debatematch.domain.reaction.Reaction
import com.example.debatematch.domain.reaction.exception.InvalidDebateReactionException
import com.example.debatematch.domain.reaction.presentation.dto.ReactionRequest
import com.example.debatematch.domain.reaction.psersistence.ReactionRepository
import com.example.debatematch.domain.user.facade.UserFacade
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class ReactionService(
    private val reactionRepository: ReactionRepository,
    private val userFacade: UserFacade,
    private val debateRepository: DebateRepository
) {
    @Transactional
    fun execute(request: ReactionRequest) {
        val user = userFacade.currentUser()
        val debate = debateRepository.findById(request.debateId).orElseThrow()
        if (debate.status != DebateStatus.DONE) throw InvalidDebateReactionException

        val reaction = if (reactionRepository.existsByDebateIdAndUserId(
                request.debateId,
                user.id!!
            )
        ) reactionRepository.findByDebateIdAndUserId(request.debateId, user.id!!) else reactionRepository.save(
            Reaction(
                debateId = request.debateId,
                userId = user.id!!,
                request.reaction
            )
        )
        reaction!!.reaction = request.reaction
    }
}