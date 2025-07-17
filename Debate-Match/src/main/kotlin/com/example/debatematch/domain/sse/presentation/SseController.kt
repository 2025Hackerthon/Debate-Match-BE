package com.example.debatematch.domain.sse.presentation

import com.example.debatematch.domain.debate.enum.DebateSide
import com.example.debatematch.domain.sse.service.SseConnectService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/sse")
class SseController(
    private val sseConnectService: SseConnectService
) {
    @GetMapping(path = ["/connect"], produces = [MediaType.TEXT_EVENT_STREAM_VALUE])
    fun connect(
        @RequestParam debateId: UUID,
        side: DebateSide
    ) = sseConnectService.execute(debateId, side)
}
