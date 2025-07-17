package com.example.debatematch.domain.debate.service

import com.example.debatematch.domain.debate.enum.DebateSide
import com.example.debatematch.domain.debate.exception.AlreadyStartedDebateException
import com.example.debatematch.domain.debate.facade.DebateFacade
import com.example.debatematch.domain.debate.persistence.DebateRepository
import com.example.debatematch.domain.debate.presentation.dto.DebateJoinRequest
import com.example.debatematch.domain.participated.Participated
import com.example.debatematch.domain.participated.persistence.ParticipatedRepository
import com.example.debatematch.domain.user.facade.UserFacade
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import java.util.*

@Service
class DebateJoinService(
    private val debateFacade: DebateFacade,
    private val debateRepository: DebateRepository,
    private val userFacade: UserFacade,
    private val participatedRepository: ParticipatedRepository
) {
    @Transactional
    fun execute(request: DebateJoinRequest): UUID {
        val user = userFacade.currentUser()
        if (participatedRepository.countByDebateId(request.debateId) == 2) {
            throw AlreadyStartedDebateException
        }

        var debate = debateRepository.findById(request.debateId).orElseThrow()
        participatedRepository.save(Participated(debateId = debate.id!!, userId = user.id!!, side = request.side))

        val conEmitter = debateFacade.getEmitterByDebateUuid(request.debateId, DebateSide.CON)
        conEmitter.send("match")
        val proEmitter = debateFacade.getEmitterByDebateUuid(request.debateId, DebateSide.PRO)
        proEmitter.send("match")

        return debate.id!!
    }
}
