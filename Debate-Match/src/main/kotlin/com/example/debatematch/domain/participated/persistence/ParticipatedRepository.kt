package com.example.debatematch.domain.participated.persistence

import com.example.debatematch.domain.debate.enum.DebateSide
import com.example.debatematch.domain.participated.Participated
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface ParticipatedRepository: JpaRepository<Participated, UUID> {
    fun findAllByDebateId(debateId: UUID):List<Participated>
}