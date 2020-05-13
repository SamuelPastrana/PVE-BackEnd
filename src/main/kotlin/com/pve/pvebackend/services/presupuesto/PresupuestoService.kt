package com.pve.pvebackend.services.presupuesto

import com.pve.pvebackend.model.inversion.Inversion
import com.pve.pvebackend.model.presupuestos.Presupuesto
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface PresupuestoService {
    fun obtenerPresupuestosPorCodigoProyecto(codigo: String): Flux<Presupuesto>
    fun obtenerInversionesPorId(id: Int): Mono<Presupuesto>
    fun guardarPresupuestos(presupuestos: List<Presupuesto>): Mono<Void>
}