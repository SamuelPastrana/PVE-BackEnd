package com.pve.pvebackend.controllers.fianciacion

import com.pve.pvebackend.services.financiacion.FinanciacionService
import com.pve.pvebackend.services.financiacion.request.FinanciacionData
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("api_pve")
@CrossOrigin(value = ["*"], allowCredentials = "true")
class FianciacionController {

    @Autowired
    lateinit var fianciacionService: FinanciacionService

    @GetMapping("/plan_inversion/financiacion/{codigo}")
    fun obtenerFinanciacionPorCodigoProyecto(@PathVariable codigo: String): Mono<FinanciacionData> {
        return fianciacionService.obtenerFinanciacionPorCodigoProyecto(codigo)
    }

    @PostMapping("/plan_inversion/financiacion/guardar")
    fun guardarFianciacion(@RequestBody financiaciones: FinanciacionData): Mono<Void> {
        return fianciacionService.guardarFinanciacion(financiaciones)
    }

}