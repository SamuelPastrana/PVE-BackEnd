package com.pve.pvebackend.services.planViable

import com.pve.pvebackend.model.planViable.PlanViable
import com.pve.pvebackend.model.planViable.PlanViableRequest
import com.pve.pvebackend.model.planViable.PlanViableResponse
import com.pve.pvebackend.model.proyecto.Proyecto
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface PlanViableService {
    fun obtenerProyectosPorUsuario(usuario: String): Flux<Proyecto>
    fun obtenerProyectoPorCodigo(codigo: String): Mono<Proyecto>
    fun guardarProyecto(proyecto: Proyecto): Mono<Proyecto>
}