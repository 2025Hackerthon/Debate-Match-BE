package com.example.debatematch.domain.debate.service

import com.example.debatematch.domain.debate.enum.DebateSide
import com.example.debatematch.domain.debate.persistence.DebateRepository
import com.example.debatematch.domain.debate.presentation.dto.DebateDoneQueryAllResponse
import com.example.debatematch.domain.debatetag.persistence.DebateTagRepository
import com.example.debatematch.domain.participated.persistence.ParticipatedRepository
import com.example.debatematch.domain.reaction.psersistence.ReactionRepository
import com.example.debatematch.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class DebateMyQueryAllService(
    private val userFacade: UserFacade,
    private val debateRepository: DebateRepository,
    private val debateTagRepository: DebateTagRepository,
    private val reactionRepository: ReactionRepository,
    private val participatedRepository: ParticipatedRepository
) {
    @Transactional(readOnly = true)
    fun execute():List<DebateDoneQueryAllResponse>{
        val user = userFacade.currentUser()

        val participated = participatedRepository.findAllByUserId(user.id!!)

        val debates = participated.map {
            debateRepository.findById(it.debateId).orElseThrow()
        }

        return debates.map {
            DebateDoneQueryAllResponse(
                debateId = it.id!!,
                title = it.title,
                tags = debateTagRepository.findAllByDebateId(it.id!!).map { it.tag },
                con = reactionRepository.countByDebateIdAndReaction(it.id!!, DebateSide.CON),
                pro = reactionRepository.countByDebateIdAndReaction(it.id!!, DebateSide.PRO),
            )
        }
    }
}