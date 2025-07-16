package com.example.debatematch.domain.participated.persistence

import com.example.debatematch.domain.participated.Participated
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ParticipatedRepository : JpaRepository<Participated, UUID> {
    fun findAllByDebateId(debateId: UUID): List<Participated>

    fun findByDebateIdAndUserId(
        debateId: UUID,
        userId: UUID,
    ): Participated?
}
