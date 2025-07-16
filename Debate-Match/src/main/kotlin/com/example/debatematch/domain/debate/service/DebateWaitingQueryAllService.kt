package com.example.debatematch.domain.debate.service

import com.example.debatematch.domain.debate.enum.DebateStatus
import com.example.debatematch.domain.debate.persistence.DebateRepository
import com.example.debatematch.domain.debate.presentation.dto.DebateQueryResponse
import com.example.debatematch.domain.debatetag.persistence.DebateTagRepository
import com.example.debatematch.domain.participated.persistence.ParticipatedRepository
import com.example.debatematch.domain.reaction.psersistence.ReactionRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class DebateWaitingQueryAllService(
    private val debateRepository: DebateRepository,
    private val reactionRepository: ReactionRepository,
    private val debateTagRepository: DebateTagRepository,
    private val participatedRepository: ParticipatedRepository,
) {
    @Transactional
    fun execute(): List<DebateQueryResponse> {
        val debates = debateRepository.findAllByStatus(DebateStatus.WAIT)
        return debates.map {
            DebateQueryResponse(
                title = it.title,
                tags = debateTagRepository.findAllByDebateId(it.id!!).map { it.tag },
                debateId = it.id!!,
                side = participatedRepository.findAllByDebateId(it.id!!)[0].side.changeSide(),
            )
        }
    }
}
