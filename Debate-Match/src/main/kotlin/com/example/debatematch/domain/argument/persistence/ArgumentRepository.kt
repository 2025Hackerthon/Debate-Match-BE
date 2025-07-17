package com.example.debatematch.domain.argument.persistence

import com.example.debatematch.domain.argument.Argument
import com.example.debatematch.domain.debate.enum.DebateLevel
import com.example.debatematch.domain.debate.enum.DebateSide
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ArgumentRepository : JpaRepository<Argument, UUID> {
    fun existsBySideAndLevelAndDebateId(
        side: DebateSide,
        level: DebateLevel,
        debateId: UUID
    ): Boolean

    fun findAllByDebateIdAndLevel(
        debateId: UUID,
        level: DebateLevel
    ): List<Argument>

    fun findAllByDebateId(debateId: UUID): List<Argument>

    fun existsByDebateIdAndLevelAndSide(debateId: UUID, level: DebateLevel, side: DebateSide): Boolean
}
