package com.example.debatematch.domain.debatetag

import com.example.debatematch.domain.debatetag.enum.SubjectTag
import com.example.debatematch.global.base.BaseEntity
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.Table
import java.util.UUID

@Entity
@Table(name = "tbl_debate_tag")
class DebateTag(
    val debateId: UUID,
    @Enumerated(EnumType.STRING)
    val tag: SubjectTag,
): BaseEntity() {
}