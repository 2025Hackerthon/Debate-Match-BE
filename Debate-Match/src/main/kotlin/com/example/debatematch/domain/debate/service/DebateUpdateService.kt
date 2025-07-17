package com.example.debatematch.domain.debate.service

import com.example.debatematch.domain.argument.Argument
import com.example.debatematch.domain.argument.persistence.ArgumentRepository
import com.example.debatematch.domain.debate.domain.Debate
import com.example.debatematch.domain.debate.enum.DebateLevel
import com.example.debatematch.domain.debate.enum.DebateSide
import com.example.debatematch.domain.debate.facade.DebateFacade
import com.example.debatematch.domain.debate.persistence.DebateRepository
import com.example.debatematch.domain.debate.presentation.dto.DebateUpdateRequest
import com.example.debatematch.domain.debate.presentation.dto.SendSseResponse
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter
import java.util.UUID

@Service
class DebateUpdateService(
    private val debateFacade: DebateFacade,
    private val argumentRepository: ArgumentRepository,
    private val debateRepository: DebateRepository,
    private val debateSummeryService: DebateSummeryService
) {
    @Transactional
    fun execute(request: DebateUpdateRequest): UUID {
        val id =
            argumentRepository.save(
                Argument(debateId = request.debateId, side = request.side, level = request.level, content = request.content),
            ).id
        if (argumentRepository.existsBySideAndLevelAndDebateId(request.side.changeSide(), request.level, request.debateId))
            {
                val arguments = argumentRepository.findAllByDebateIdAndLevel(request.debateId, request.level)
                val data = arguments.map { SendSseResponse(level = it.level, content = it.content, side = it.side) }
                val proEmitter = debateFacade.getEmitterByDebateUuid(request.debateId, DebateSide.PRO)
                proEmitter.send(SseEmitter.event().name("next level").data(data))
                val conEmitter = debateFacade.getEmitterByDebateUuid(request.debateId, DebateSide.CON)
                conEmitter.send(SseEmitter.event().name("next level").data(data))

                if (request.level == DebateLevel.CONCLUSION)
                    {
                        val debate: Debate = debateRepository.findById(request.debateId).orElseThrow()
                        debate.updateToDone()
                        debateSummeryService.execute(debate.id!!)
                    }
            }

        return id!!
    }
}
