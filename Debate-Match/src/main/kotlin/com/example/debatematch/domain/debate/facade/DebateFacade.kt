package com.example.debatematch.domain.debate.facade

import com.example.debatematch.domain.debate.enum.DebateSide
import org.springframework.stereotype.Component
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter
import java.util.*

@Component
class DebateFacade {
    companion object {
        var eimotters: HashMap<String, SseEmitter> = HashMap()
    }

    fun getEmitterByDebateUuid(
        uuid: UUID,
        side: DebateSide
    ): SseEmitter {
        val key = uuid.toString() + side.name
        println(key)
        return eimotters[key] ?: throw RuntimeException("No eimotter for $uuid")
    }

    fun createEmitter(
        uuid: UUID,
        side: DebateSide
    ): SseEmitter {
        val key = uuid.toString() + side.name
        val emitter = SseEmitter(Long.MAX_VALUE)
        eimotters[key] = emitter
        println(key)
        return emitter
    }

    fun deleteEmitterByDebateUuid(
        uuid: UUID,
        side: DebateSide
    ){
        val key = uuid.toString() + side.name
        eimotters[key]!!.complete()
        eimotters.remove(key)
    }
}
