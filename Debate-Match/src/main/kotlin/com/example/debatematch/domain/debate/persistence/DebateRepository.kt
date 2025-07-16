package com.example.debatematch.domain.debate.persistence

import com.example.debatematch.domain.debate.domain.Debate
import com.example.debatematch.domain.debate.enum.DebateStatus
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface DebateRepository : JpaRepository<Debate, UUID> {
    fun findAllByStatus(status: DebateStatus): List<Debate>

    override fun findById(id: UUID): Optional<Debate>
}
