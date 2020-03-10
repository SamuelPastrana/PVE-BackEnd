package com.pve.pvebackend.services.inversion

import com.pve.pvebackend.model.inversion.Inversion
import com.pve.pvebackend.model.planViable.PlanViable
import com.pve.pvebackend.repository.inversion.InversionRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class InversionServiceImple : InversionService {

    @Autowired
    lateinit var repository: InversionRepository

    override fun obtenerInversionesPorCodigo(id: Int): Mono<Inversion> {
        return Mono.just(repository.findInversionById(id))

    }

    override fun obtenerInversionesPorUsuario(nombre: String): Flux<Inversion> {
        return Flux.fromIterable(repository.findInversionByUsuario(nombre))
    }

}

