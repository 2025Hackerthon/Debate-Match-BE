package com.example.debatematch.domain.debate.service

import com.example.debatematch.domain.debate.enum.DebateSide
import com.example.debatematch.domain.debate.enum.DebateStatus
import com.example.debatematch.domain.debate.facade.DebateFacade
import com.example.debatematch.domain.debate.persistence.DebateRepository
import com.example.debatematch.domain.debate.presentation.dto.DebateReadyRequest
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class DebateReadyService(
    private val debateFacade: DebateFacade,
    private val debateRepository: DebateRepository,
) {
    @Transactional
    fun execute(request: DebateReadyRequest) {
        val debate = debateRepository.findById(request.debateId).orElseThrow()
        if (debate.status == DebateStatus.WAIT) {
            debate.status = DebateStatus.PLAY
        } else
        {
            val conEmitter = debateFacade.getEmitterByDebateUuid(request.debateId, DebateSide.CON)
            conEmitter.send("ready")
            val proEmitter = debateFacade.getEmitterByDebateUuid(request.debateId, DebateSide.PRO)
            proEmitter.send("ready")
        }
    }
}
