package com.example.debatematch.domain.debate.enum

enum class DebateSide {
    PRO,    // 찬성
    CON ;    // 반대

    fun changeSide(): DebateSide {
        return when (this) {
            DebateSide.PRO -> CON
            DebateSide.CON -> PRO
        }
    }
}