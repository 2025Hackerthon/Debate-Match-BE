package com.example.debatematch.domain.argument

import com.example.debatematch.domain.debate.enum.DebateLevel
import com.example.debatematch.domain.debate.enum.DebateSide
import com.example.debatematch.global.base.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.Table
import java.util.*

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
) : BaseEntity()
