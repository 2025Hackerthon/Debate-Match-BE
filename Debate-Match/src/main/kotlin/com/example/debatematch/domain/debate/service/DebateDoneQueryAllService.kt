package com.example.debatematch.domain.debate.service

import com.example.debatematch.domain.debate.enum.DebateSide
import com.example.debatematch.domain.debate.enum.DebateStatus
import com.example.debatematch.domain.debate.persistence.DebateRepository
import com.example.debatematch.domain.debate.presentation.dto.DebateDoneQueryAllResponse
import com.example.debatematch.domain.debatetag.persistence.DebateTagRepository
import com.example.debatematch.domain.reaction.psersistence.ReactionRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class DebateDoneQueryAllService(
    private val debateRepository: DebateRepository,
    private val reactionRepository: ReactionRepository,
    private val debateTagRepository: DebateTagRepository
) {
    @Transactional(readOnly = true)
    fun execute(): List<DebateDoneQueryAllResponse> {
        val debates = debateRepository.findAllByStatus(DebateStatus.DONE)

        return debates.map {
            DebateDoneQueryAllResponse(
                debateId = it.id!!,
                title = it.title,
                tags = debateTagRepository.findAllByDebateId(it.id!!).map { it.tag },
                con = reactionRepository.countByDebateIdAndReaction(it.id!!, DebateSide.CON),
                pro = reactionRepository.countByDebateIdAndReaction(it.id!!, DebateSide.PRO)
            )
        }
    }
}
