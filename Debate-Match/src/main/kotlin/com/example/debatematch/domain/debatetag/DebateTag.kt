package com.example.debatematch.domain.debatetag

import com.example.debatematch.global.base.BaseEntity
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "tbl_debate_tag")
class DebateTag(
    debateId: String,
    tagId: String,
): BaseEntity() {
}