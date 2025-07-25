package com.example.debatematch.domain.debate.presentation

import com.example.debatematch.domain.debate.presentation.dto.DebateCancelRequest
import com.example.debatematch.domain.debate.presentation.dto.DebateCreateRequest
import com.example.debatematch.domain.debate.presentation.dto.DebateJoinCancelRequest
import com.example.debatematch.domain.debate.presentation.dto.DebateJoinRequest
import com.example.debatematch.domain.debate.presentation.dto.DebateReadyRequest
import com.example.debatematch.domain.debate.presentation.dto.DebateUpdateRequest
import com.example.debatematch.domain.debate.service.DebateCancelService
import com.example.debatematch.domain.debate.service.DebateCreateService
import com.example.debatematch.domain.debate.service.DebateDoneQueryAllService
import com.example.debatematch.domain.debate.service.DebateDoneQueryService
import com.example.debatematch.domain.debate.service.DebateJoinCancelService
import com.example.debatematch.domain.debate.service.DebateJoinService
import com.example.debatematch.domain.debate.service.DebateMyQueryAllService
import com.example.debatematch.domain.debate.service.DebateReadyService
import com.example.debatematch.domain.debate.service.DebateUpdateService
import com.example.debatematch.domain.debate.service.DebateWaitingQueryAllService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/debate")
class DebateController(
    private val debateCreateService: DebateCreateService,
    private val debateJoinService: DebateJoinService,
    private val debateUpdateService: DebateUpdateService,
    private val debateWaitingQueryAllService: DebateWaitingQueryAllService,
    private val debateReadyService: DebateReadyService,
    private val debateDoneQueryAllService: DebateDoneQueryAllService,
    private val debateDoneQueryService: DebateDoneQueryService,
    private val debateMyQueryAllService: DebateMyQueryAllService,
    private val debateJoinCancelService: DebateJoinCancelService,
    private val debateCancelService: DebateCancelService
) {
    @PostMapping("/create")
    fun create(
        @RequestBody request: DebateCreateRequest
    ) = debateCreateService.execute(request)

    @PostMapping("/join")
    fun join(
        @RequestBody request: DebateJoinRequest
    ) = debateJoinService.execute(request)

    @PostMapping("/update")
    fun update(
        @RequestBody request: DebateUpdateRequest
    ) = debateUpdateService.execute(request)

    @GetMapping("/wait")
    fun getWait() = debateWaitingQueryAllService.execute()

    @PostMapping("/ready")
    fun ready(
        @RequestBody request: DebateReadyRequest
    ) = debateReadyService.execute(request)

    @GetMapping("/done-list")
    fun getDoneAll() = debateDoneQueryAllService.execute()

    @GetMapping("/done")
    fun getDone(
        @RequestParam id: UUID
    ) = debateDoneQueryService.execute(id)

    @GetMapping("/my-debate")
    fun getMyDebate() = debateMyQueryAllService.execute()

    @DeleteMapping("/{debateId}/join/cancel")
    fun cancelJoin(@PathVariable debateId: UUID, @RequestBody request: DebateJoinCancelRequest) = debateJoinCancelService.execute(debateId, request)

    @DeleteMapping("/{debateId}/cancel")
    fun cancel(@PathVariable debateId: UUID, @RequestBody request: DebateCancelRequest) = debateCancelService.execute(debateId, request)
}
