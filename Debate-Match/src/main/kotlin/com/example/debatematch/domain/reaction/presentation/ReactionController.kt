package com.example.debatematch.domain.reaction.presentation

import com.example.debatematch.domain.reaction.presentation.dto.ReactionRequest
import com.example.debatematch.domain.reaction.serivce.ReactionService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class ReactionController(
    private val reactionService: ReactionService
) {
    @PostMapping("/reaction")
    fun reaction(@RequestBody request: ReactionRequest) = reactionService.execute(request)
}