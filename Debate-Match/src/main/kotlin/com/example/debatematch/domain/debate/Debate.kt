package com.example.debatematch.domain.debate.domain

import com.example.debatematch.domain.debate.enum.DetadeStatus
import com.example.debatematch.global.base.BaseEntity
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.Table
import org.springframework.data.relational.core.mapping.Column
import java.util.*

@Entity
@Table(name = "tbl_debate")
class Debate (
    @Enumerated(EnumType.STRING)
    var status: DetadeStatus,

    var introductionA: String,

    var introductionB: String,

    var rebuttalA: String,

    var rebuttalB: String,

    var defenseA: String,

    var defenseB: String,

    var conclusionA: String,

    var conclusionB: String,

    var summarize: String,

    var userA: UUID,

    var userB: UUID,

    ): BaseEntity() {}