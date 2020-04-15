package com.pve.pvebackend.services.presupuesto

import com.pve.pvebackend.model.inversion.Inversion
import com.pve.pvebackend.model.presupuestos.Presupuesto
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface PresupuestoService {
    fun obtenerInversionesPorCodigoPlan(codigo: String): List<Presupuesto>
    fun obtenerInversionesPorCodigo(id: Int): Mono<Presupuesto>
    fun guardarPresupuestos(presupuestos: List<Presupuesto>, codigoPlan: String): Mono<Void>
}