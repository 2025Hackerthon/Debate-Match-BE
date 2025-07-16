package com.example.debatematch.domain.debate.service

import com.example.debatematch.domain.debate.domain.Debate
import com.example.debatematch.domain.debate.persistence.DebateRepository
import com.example.debatematch.domain.debate.presentation.dto.DebateCreateRequest
import com.example.debatematch.domain.debatetag.DebateTag
import com.example.debatematch.domain.debatetag.persistence.DebateTagRepository
import com.example.debatematch.domain.participated.Participated
import com.example.debatematch.domain.participated.persistence.ParticipatedRepository
import com.example.debatematch.domain.user.facade.UserFacade
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import java.util.*

@Service
class DebateCreateService(
    private val debateRepository: DebateRepository,
    private val debateTagRepository: DebateTagRepository,
    private val userFacade: UserFacade,
    private val participatedRepository: ParticipatedRepository,
) {
    @Transactional
    fun execute(request: DebateCreateRequest): UUID {
        val user = userFacade.currentUser()

        val debate = debateRepository.save(Debate(title = request.title))
        val id = debate.id ?: throw IllegalStateException("Debate id is null")
        request.tagList.map { debateTagRepository.save(DebateTag(debateId = id, tag = it)) }

        participatedRepository.save(Participated(id, user.id!!, request.side))

        return id
    }
}
