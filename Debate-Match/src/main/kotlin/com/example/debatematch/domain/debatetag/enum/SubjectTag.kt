package com.example.debatematch.domain.debatetag.enum

enum class SubjectTag(val displayName: String) {
    KOREAN("국어"),
    MATH("수학"),
    ENGLISH("영어"),
    KOREAN_HISTORY("한국사"),
    WORLD_HISTORY("세계사"),
    SOCIAL_STUDIES("사회"),
    SCIENCE("과학"),
    ART("미술"),
    PHYSICAL_EDUCATION("체육"),
    TECHNOLOGY("기술"),
    MUSIC("음악"),
    ETHICS("윤리"),
    SECOND_LANGUAGE("제2외국어"),
    LIBERAL_ARTS("교양"),
    IT("IT")
    ;

    override fun toString(): String = displayName
}
