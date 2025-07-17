package com.example.debatematch.domain.debate.service

import com.example.debatematch.domain.argument.persistence.ArgumentRepository
import com.example.debatematch.domain.debate.enum.DebateStatus
import com.example.debatematch.domain.debate.exception.InvalidCancelArgumentException
import com.example.debatematch.domain.debate.persistence.DebateRepository
import com.example.debatematch.domain.debate.presentation.dto.DebateCancelRequest
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class DebateCancelService(
    private val argumentRepository: ArgumentRepository,
    private val debateRepository: DebateRepository
) {
    @Transactional
    fun execute(debateId: UUID, request: DebateCancelRequest) {
        if (argumentRepository.existsBySideAndLevelAndDebateId(side = request.side, level = request.level, debateId = debateId) ||
            debateRepository.findById(debateId).orElseThrow().status == DebateStatus.PLAY
        ) {
            throw InvalidCancelArgumentException
        }

        argumentRepository.deleteByDebateIdAndLevelAndSide(debateId = debateId, level = request.level, side = request.side)
    }
}
