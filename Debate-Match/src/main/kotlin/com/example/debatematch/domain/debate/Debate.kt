package com.example.debatematch.domain.debate.domain

import com.example.debatematch.domain.debate.enum.DebateStatus
import com.example.debatematch.global.base.BaseEntity
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.Table

@Entity
@Table(name = "tbl_debate")
class Debate (
    @Enumerated(EnumType.STRING)
    var status: DebateStatus = DebateStatus.WAIT,
    var summarize: String? = null,
    val title: String


): BaseEntity(){
    fun updateToDone(){
        status = DebateStatus.DONE
    }
}