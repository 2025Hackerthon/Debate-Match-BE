package com.example.debatematch.domain.debate.presentation

import com.example.debatematch.domain.debate.persistence.DebateRepository
import com.example.debatematch.domain.debate.presentation.dto.DebateCreateRequest
import com.example.debatematch.domain.debate.presentation.dto.DebateJoinRequest
import com.example.debatematch.domain.debate.presentation.dto.DebateReadyRequest
import com.example.debatematch.domain.debate.presentation.dto.DebateUpdateRequest
import com.example.debatematch.domain.debate.service.*
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/debate")
class DebateController(
    private val debateCreateService: DebateCreateService,
    private val debateJoinService: DebateJoinService,
    private val debateUpdateService: DebateUpdateService,
    private val debateWaitingQueryAllService: DebateWaitingQueryAllService,
    private val debateReadyService: DebateReadyService
) {
    @PostMapping("/create")
    fun create(@RequestBody request: DebateCreateRequest)= debateCreateService.execute(request)


    @PostMapping("/join")
    fun join(@RequestBody request: DebateJoinRequest)= debateJoinService.execute(request)

    @PostMapping("/update")
    fun update(@RequestBody request: DebateUpdateRequest)= debateUpdateService.execute(request)

    @GetMapping("/wait")
    fun getWait() = debateWaitingQueryAllService.execute()

    @PostMapping("/ready")
    fun ready(@RequestBody request: DebateReadyRequest) = debateReadyService.execute(request)
}