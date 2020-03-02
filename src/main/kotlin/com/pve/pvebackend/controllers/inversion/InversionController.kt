package com.pve.pvebackend.controllers.inversion

import com.pve.pvebackend.model.inversion.Inversion
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("api_pve")
@CrossOrigin(value = ["*"], allowCredentials = "true")
class InversionController {

    @GetMapping("/inversion")
    fun getInverion(): Mono<Inversion> {
        return Mono.empty();
    }

}