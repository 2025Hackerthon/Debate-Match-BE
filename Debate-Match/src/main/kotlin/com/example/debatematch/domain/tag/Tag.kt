package com.example.debatematch.domain.tag

import com.example.debatematch.global.base.BaseEntity
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "tbl_tag")
class Tag(
    name: String
): BaseEntity() {
}