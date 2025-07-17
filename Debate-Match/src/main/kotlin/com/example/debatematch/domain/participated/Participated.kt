package com.example.debatematch.domain.participated

import com.example.debatematch.domain.debate.enum.DebateSide
import com.example.debatematch.global.base.BaseEntity
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.Table
import java.util.UUID

@Entity
@Table(name = "tbl_participated")
class Participated(
    val debateId: UUID,
    val userId: UUID,
    @Enumerated(EnumType.STRING)
    val side: DebateSide,
    var feedback: String? = null,
) : BaseEntity()
