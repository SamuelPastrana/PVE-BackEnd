package com.pve.pvebackend.services.inversion

import com.pve.pvebackend.model.inversion.Inversion
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface InversionService {
    fun obtenerInversionPorId(id: Int): Mono<Inversion>
    fun obtenerInversionesPorCodigoProyecto(codigo: String): Flux<Inversion>
    fun guardarInversiones(inversiones: List<Inversion>): Mono<Void>
}