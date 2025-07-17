package com.example.debatematch.domain.user

import com.example.debatematch.domain.user.enum.EducationLevel
import com.example.debatematch.global.base.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.Table
import lombok.AllArgsConstructor

@Entity
@Table(name = "tbl_user")
@AllArgsConstructor
class User(
    @Column(nullable = false)
    val accountId: String,
    @Column(nullable = false)
    val password: String,
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    var educationLevel: EducationLevel
) : BaseEntity()
