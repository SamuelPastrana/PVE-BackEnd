package com.pve.pvebackend.services.planViable

import com.pve.pvebackend.model.planViable.PlanViableRequest
import com.pve.pvebackend.model.planViable.PlanViableResponse
import reactor.core.publisher.Mono

interface PlanViableService {
    fun obtenerPlanViablePorUsuario(usuario: String): Mono<PlanViableResponse>
    fun guardarPlanViableInformacion(planViable: PlanViableRequest): Mono<Void>
}