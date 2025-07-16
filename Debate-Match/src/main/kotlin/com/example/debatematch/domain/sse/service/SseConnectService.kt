package com.example.debatematch.domain.sse.service

import com.example.debatematch.domain.debate.enum.DebateSide
import com.example.debatematch.domain.debate.facade.DebateFacade
import org.springframework.stereotype.Service
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter
import java.util.*

@Service
class SseConnectService(
    private val debateFacade: DebateFacade,
) {
    fun execute(
        debateId: UUID,
        side: DebateSide,
    ): SseEmitter {
        val emitter = debateFacade.createEmitter(debateId, side)
        emitter.send("HelloWorld")
        return emitter
    }
}
