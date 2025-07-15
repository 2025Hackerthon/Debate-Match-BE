package com.example.debatematch.domain.user

import com.example.debatematch.domain.user.enum.EducationLevel
import com.example.debatematch.global.base.BaseEntity
import jakarta.persistence.*
import lombok.AllArgsConstructor
import java.time.LocalDateTime
import java.util.*

@Entity
@Table(name = "tbl_user")
@AllArgsConstructor
class User (

    @Column(nullable = false)
    val accountId : String,

    @Column(nullable = false)
    val password : String,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    val educationLevel: EducationLevel,
): BaseEntity() {}