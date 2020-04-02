package com.pve.pvebackend.services.inversion

import com.pve.pvebackend.model.inversion.Inversion
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface InversionService {
    fun obtenerInversionesPorCodigo(id: Int): Mono<Inversion>
    fun obtenerInversionesPorCodigoPlan(codigo: String): Flux<Inversion>
    fun guardarInversiones(inversiones: List<Inversion>, codigoPlan: String): Mono<Void>
}