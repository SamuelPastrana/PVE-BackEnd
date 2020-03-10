package com.pve.pvebackend.controllers.inversion

import com.pve.pvebackend.model.inversion.Inversion
import com.pve.pvebackend.services.inversion.InversionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("api_pve")
@CrossOrigin(value = ["*"], allowCredentials = "true")
class InversionController() {

    @Autowired
    lateinit var service: InversionService;

    @GetMapping("/inversiones/{id}")
    fun getInveriones(@PathVariable id: Int): Mono<Inversion> {
        return service.obtenerInversionesPorCodigo(id);
    }

    @GetMapping("/inversion/{usuario}")
    fun getString(@PathVariable usuario: String): Flux<Inversion> {
        return service.obtenerInversionesPorUsuario(usuario);
    }

}