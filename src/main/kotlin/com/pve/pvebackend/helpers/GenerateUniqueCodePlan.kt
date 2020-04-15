package com.pve.pvebackend.helpers

import java.util.*

interface GenerateUniqueCodePlan {
    fun generateCodigoPlan(): String? {
        val codigos: List<String> = UUID.randomUUID().toString().split("-")
        return codigos[codigos.size - 1]
    }
}