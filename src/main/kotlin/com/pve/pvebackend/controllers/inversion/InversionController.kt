package com.pve.pvebackend.controllers.inversion

import com.pve.pvebackend.model.inversion.Inversion
import com.pve.pvebackend.model.proyecto.Proyecto
import com.pve.pvebackend.services.inversion.InversionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("api_pve")
@CrossOrigin(value = ["*"], allowCredentials = "true")
class InversionController {

    @Autowired
    lateinit var inversionService: InversionService;

    @GetMapping("/plan_inversion/inversiones/{codigo}")
    fun obtenerInversionesPorCodigoProyecto(@PathVariable codigo: String): Flux<Inversion> {
        return inversionService.obtenerInversionesPorCodigoProyecto(codigo)
    }

    @PostMapping("/plan_inversion/inversiones/guardar")
    fun guardarInversiones(@RequestBody inversiones: List<Inversion>): Mono<Void> {
        return inversionService.guardarInversiones(inversiones)
    }

}