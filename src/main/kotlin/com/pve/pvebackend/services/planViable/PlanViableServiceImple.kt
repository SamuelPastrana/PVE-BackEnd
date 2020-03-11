package com.pve.pvebackend.services.planViable

import com.pve.pvebackend.model.inversion.Inversion
import com.pve.pvebackend.model.planViable.PlanViable
import com.pve.pvebackend.model.planViable.PlanViableRequest
import com.pve.pvebackend.repository.inversion.InversionRepository
import com.pve.pvebackend.repository.planViable.PlanViableRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class PlanViableServiceImple: PlanViableService {

    @Autowired
    lateinit var repository: InversionRepository

    @Autowired
    lateinit var planViableRepository: PlanViableRepository

    override fun obtenerPlanViablePorUsuario(usuario: String): Mono<PlanViableRequest> {
        return Mono.just(planViableRepository.findPlanViableByIdUsuario(usuario))
                .flatMap { planViable -> Mono.just(repository.findInversionByCodigoPlan(planViable.codigoPlan))
                        .flatMap { inversiones -> crearObjetoPlanViable(inversiones, planViable) }}
    }

    fun crearObjetoPlanViable(inversiones: List<Inversion>, planViable: PlanViable): Mono<PlanViableRequest> {
        return Mono.just(PlanViableRequest(inversiones, planViable));
    }

}