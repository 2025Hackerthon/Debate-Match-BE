package com.example.debatematch.domain.debate.service

import com.example.debatematch.domain.debate.enum.DebateStatus
import com.example.debatematch.domain.debate.facade.DebateFacade
import com.example.debatematch.domain.debate.persistence.DebateRepository
import com.example.debatematch.domain.debate.presentation.dto.DebateJoinRequest
import com.example.debatematch.domain.participated.Participated
import com.example.debatematch.domain.participated.persistence.ParticipatedRepository
import com.example.debatematch.domain.user.facade.UserFacade
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class DebateJoinService(
    private val debateFacade: DebateFacade,
    private val debateRepository: DebateRepository,
    private val userFacade: UserFacade,
    private val participatedRepository: ParticipatedRepository
) {
    @Transactional
    fun execute(request: DebateJoinRequest):UUID {
        val user = userFacade.currentUser()

        var debate = debateRepository.findById(request.debateId).orElseThrow()
        participatedRepository.save(Participated(debateId = debate.id!!, userId = user.id!!, side = request.side))

        return debate.id!!
    }
}