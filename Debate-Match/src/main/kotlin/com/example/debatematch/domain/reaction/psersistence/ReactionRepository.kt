package com.example.debatematch.domain.reaction.psersistence

import com.example.debatematch.domain.debate.enum.DebateSide
import com.example.debatematch.domain.reaction.Reaction
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface ReactionRepository : JpaRepository<Reaction, UUID> {
    fun countByDebateIdAndReaction(
        debateId: UUID,
        reaction: DebateSide
    ): Int

    fun findByDebateIdAndUserId(
        debateId: UUID,
        userId: UUID
    ): Reaction?

    fun existsByDebateIdAndUserId(
        debateId: UUID,
        userId: UUID
    ): Boolean
}
