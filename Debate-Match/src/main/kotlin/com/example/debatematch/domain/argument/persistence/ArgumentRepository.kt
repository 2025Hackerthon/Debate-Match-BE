package com.example.debatematch.domain.argument.persistence

import com.example.debatematch.domain.argument.Argument
import com.example.debatematch.domain.debate.domain.Debate
import com.example.debatematch.domain.debate.enum.DebateLevel
import com.example.debatematch.domain.debate.enum.DebateSide
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface ArgumentRepository: JpaRepository<Argument, UUID> {
    fun existsBySideAndLevelAndDebateId(side: DebateSide, level: DebateLevel, debateId: UUID): Boolean
    fun findAllByDebateIdAndLevel(debateId: UUID, level: DebateLevel): List<Argument>
}