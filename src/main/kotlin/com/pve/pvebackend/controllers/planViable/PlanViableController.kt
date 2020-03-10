package com.pve.pvebackend.controllers.planViable

import com.pve.pvebackend.model.planViable.PlanViable
import com.pve.pvebackend.services.planViable.PlanViableService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono

@RestController
@RequestMapping("api_pve")
@CrossOrigin(value = ["*"], allowCredentials = "true")
class PlanViableController() {

    @Autowired
    lateinit var service: PlanViableService;

    @GetMapping("/plan_inversion/{usuario}")
    fun obtenerPlanViablePorUsuario(@PathVariable usuario: String): Mono<PlanViable> {
        return service.obtenerPlanViablePorUsuario(usuario);
    }

}