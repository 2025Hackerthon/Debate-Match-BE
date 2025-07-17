package com.example.debatematch.domain.reaction

import com.example.debatematch.domain.debate.enum.DebateSide
import com.example.debatematch.global.base.BaseEntity
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.Table
import java.util.UUID

@Entity
@Table(name = "tbl_reaction")
class Reaction(
    val debateId: UUID,
    val userId: UUID,
    @Enumerated(EnumType.STRING)
    var reaction: DebateSide
) : BaseEntity() {
    fun update(side: DebateSide) {
        this.reaction = side
    }
}
