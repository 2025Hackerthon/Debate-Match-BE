package com.example.debatematch.domain.debate.service

import com.example.debatematch.domain.argument.persistence.ArgumentRepository
import com.example.debatematch.domain.debate.persistence.DebateRepository
import com.example.debatematch.domain.debate.presentation.dto.Argument
import com.example.debatematch.domain.debate.presentation.dto.DebateDoneQueryResponse
import com.example.debatematch.domain.participated.persistence.ParticipatedRepository
import com.example.debatematch.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class DebateDoneQueryService(
    private val debateRepository: DebateRepository,
    private val argumentRepository: ArgumentRepository,
    private val userFacade: UserFacade,
    private val participatedRepository: ParticipatedRepository,
) {
    @Transactional(readOnly = true)
    fun execute(debateId: UUID): DebateDoneQueryResponse  {
        val user = userFacade.currentUserOrNull()

        val arguments = argumentRepository.findAllByDebateId(debateId)

        val feedback = if (user != null) participatedRepository.findByDebateIdAndUserId(debateId, user.id!!)!!.feedback else null

        val debate = debateRepository.findById(debateId).orElseThrow()
        return DebateDoneQueryResponse(
            summary = debate.summary,
            feedback = feedback,
            data = arguments.map { Argument(it.level, it.content, it.side) },
        )
    }
}
