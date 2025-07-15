package com.example.debatematch.domain.debate.persistence

import com.example.debatematch.domain.debate.domain.Debate
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface DebateRepository : JpaRepository<Debate, UUID> {
}