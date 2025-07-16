package com.example.debatematch.domain.argument

import com.example.debatematch.domain.debate.enum.DebateLevel
import com.example.debatematch.domain.debate.enum.DebateSide
import com.example.debatematch.global.base.BaseEntity
import jakarta.persistence.*
import java.util.UUID

@Entity
@Table(name = "tbl_argument")
class Argument(
    @Column(nullable = false)
    val debateId: UUID,
    @Enumerated(EnumType.STRING)
    val side: DebateSide,
    @Enumerated(EnumType.STRING)
    val level: DebateLevel,
    val content: String
): BaseEntity() {
}