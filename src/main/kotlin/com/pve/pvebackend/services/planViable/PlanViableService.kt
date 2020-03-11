package com.pve.pvebackend.services.planViable

import com.pve.pvebackend.model.inversion.Inversion
import com.pve.pvebackend.model.planViable.PlanViable
import com.pve.pvebackend.model.planViable.PlanViableRequest
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface PlanViableService {
    fun obtenerPlanViablePorUsuario(usuario: String): Mono<PlanViableRequest>
}