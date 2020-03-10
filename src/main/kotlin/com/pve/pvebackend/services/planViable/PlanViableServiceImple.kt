package com.pve.pvebackend.services.planViable

import com.pve.pvebackend.model.inversion.Inversion
import com.pve.pvebackend.model.planViable.PlanViable
import com.pve.pvebackend.repository.inversion.InversionRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class PlanViableServiceImple: PlanViableService {

    @Autowired
    lateinit var repository: InversionRepository

    override fun obtenerPlanViablePorUsuario(usuario: String): Mono<PlanViable> {
        return Mono.just(repository.findInversionByUsuario(usuario))
                .flatMap { inversion -> crearPlanViable(inversion) }
    }

    fun crearPlanViable(inversiones: List<Inversion>): Mono<PlanViable> {
        return Mono.just(PlanViable(inversiones));
    }

}