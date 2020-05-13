package com.pve.pvebackend.controllers.presupuesto

import com.pve.pvebackend.model.inversion.Inversion
import com.pve.pvebackend.model.presupuestos.Presupuesto
import com.pve.pvebackend.services.presupuesto.PresupuestoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("api_pve")
@CrossOrigin(value = ["*"], allowCredentials = "true")
class PresupuestoController {

    @Autowired
    lateinit var presupuestoService: PresupuestoService

    @GetMapping("/plan_inversion/presupuestos/{codigo}")
    fun obtenerPresupuestosPorCodigoProyecto(@PathVariable codigo: String): Flux<Presupuesto> {
        return presupuestoService.obtenerPresupuestosPorCodigoProyecto(codigo)
    }

    @PostMapping("/plan_inversion/presupuestos/guardar")
    fun guardarPresupuestos(@RequestBody presupuestos: List<Presupuesto>): Mono<Void> {
        return presupuestoService.guardarPresupuestos(presupuestos)
    }

}