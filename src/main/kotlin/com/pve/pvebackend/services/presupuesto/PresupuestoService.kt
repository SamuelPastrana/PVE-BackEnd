package com.pve.pvebackend.services.presupuesto

import com.pve.pvebackend.model.inversion.Inversion
import com.pve.pvebackend.model.presupuestos.Presupuesto
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface PresupuestoService {
    fun obtenerPresupuestoPorCodigoPlan(codigo: String): List<Presupuesto>
    fun obtenerPresupuestosPorId(id: Int): Mono<Presupuesto>
    fun guardarPresupuestos(presupuestos: List<Presupuesto>, codigoPlan: String): Mono<Void>
}