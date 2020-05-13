package com.pve.pvebackend.controllers.planViable

import com.pve.pvebackend.model.planViable.PlanViableRequest
import com.pve.pvebackend.model.planViable.PlanViableResponse
import com.pve.pvebackend.model.proyecto.Proyecto
import com.pve.pvebackend.services.planViable.PlanViableService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("api_pve")
@CrossOrigin(value = ["*"], allowCredentials = "true")
class PlanViableController {

    @Autowired
    lateinit var service: PlanViableService;

    @GetMapping("/plan_inversion/proyectos/{usuario}")
    fun obtenerProyectosPorUsuario(@PathVariable usuario: String): Flux<Proyecto> {
        return service.obtenerProyectosPorUsuario(usuario)
    }

    @GetMapping("/plan_inversion/proyecto/{codigo}")
    fun obtenerProyectoPorCodigo(@PathVariable codigo: String): Mono<Proyecto> {
        return service.obtenerProyectoPorCodigo(codigo)
    }

    @PostMapping("/plan_inversion/proyectos/guardar")
    fun guardarPlanViable(@RequestBody proyecto: Proyecto): Mono<Proyecto> {
        return service.guardarProyecto(proyecto)
    }

}