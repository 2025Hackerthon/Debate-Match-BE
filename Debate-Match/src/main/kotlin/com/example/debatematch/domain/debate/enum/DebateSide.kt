package com.example.debatematch.domain.debate.enum

enum class DebateSide(val side: String) {
    PRO("찬성측"), // 찬성
    CON("반대측") // 반대
    ;

    fun changeSide(): DebateSide {
        return when (this) {
            DebateSide.PRO -> CON
            DebateSide.CON -> PRO
        }
    }
}
