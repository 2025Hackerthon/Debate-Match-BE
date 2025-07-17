package com.example.debatematch.domain.debate.service

import com.example.debatematch.domain.debate.enum.DebateStatus
import com.example.debatematch.domain.debate.facade.DebateFacade
import com.example.debatematch.domain.debate.persistence.DebateRepository
import com.example.debatematch.domain.debate.presentation.dto.DebateJoinCancelRequest
import com.example.debatematch.domain.participated.persistence.ParticipatedRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import java.util.*

@Service
class DebateJoinCancelService(
    private val debateFacade: DebateFacade,
    private val participatedRepository: ParticipatedRepository,
    private val debateRepository: DebateRepository
) {
    @Transactional
    fun execute(debateId: UUID, request: DebateJoinCancelRequest) {
//        if (argumentRepository.existsBySideAndLevelAndDebateId(side = request.side, level = request.level, debateId = debateId)) {
//            throw DebateNotInProgressException
//        }
        participatedRepository.deleteByDebateIdAndSide(debateId = debateId, side = request.side)
        debateRepository.findById(debateId).orElseThrow().status = DebateStatus.WAIT
        debateFacade.deleteEmitterByDebateUuid(debateId, request.side)
    }
}
