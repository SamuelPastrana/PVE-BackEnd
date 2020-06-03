package com.pve.pvebackend.services.financiacion

import com.pve.pvebackend.services.financiacion.request.FinanciacionData
import reactor.core.publisher.Mono

interface FinanciacionService {
    fun obtenerFinanciacionPorCodigoProyecto(codigoProyecto: String): Mono<FinanciacionData>
    fun guardarFinanciacion(financiacionData: FinanciacionData): Mono<Void>
}