package com.example.debatematch.domain.user.enum

enum class EducationLevel(val displayName: String) {
    ELEMENTARY_SCHOOL("초등학교 졸업"),
    MIDDLE_SCHOOL("중학교 졸업"),
    HIGH_SCHOOL("고등학교 졸업"),
    UNIVERSITY("대학교 졸업"),
    GRADUATE_SCHOOL("대학원 졸업"),
    NONE("없음");

    override fun toString(): String = displayName
}