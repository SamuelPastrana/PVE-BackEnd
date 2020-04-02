package com.pve.pvebackend.services.planViable

import com.pve.pvebackend.model.inversion.Inversion
import com.pve.pvebackend.model.planViable.PlanViable
import com.pve.pvebackend.model.planViable.PlanViableRequest
import com.pve.pvebackend.model.planViable.PlanViableResponse
import com.pve.pvebackend.repository.inversion.InversionRepository
import com.pve.pvebackend.repository.planViable.PlanViableRepository
import com.pve.pvebackend.services.inversion.InversionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.function.Predicate

@Service
class PlanViableServiceImple: PlanViableService {

    @Autowired
    lateinit var inversionRepository: InversionRepository

    @Autowired
    lateinit var planViableRepository: PlanViableRepository

    @Autowired
    lateinit var inversionService: InversionService;

    override fun obtenerPlanViablePorUsuario(usuario: String): Mono<PlanViableResponse> {
        return Mono.just(planViableRepository.findPlanViableByIdUsuario(usuario))
                .flatMap { planViable -> Mono.just(inversionRepository.findInversionByCodigoPlan(planViable.codigoPlan))
                        .flatMap { inversiones -> crearObjetoPlanViableRespuesta(inversiones, planViable) }}
    }

    override fun guardarPlanViableInformacion(planViable: PlanViableRequest): Mono<Void> {
        return Mono.just(planViable)
                .filter(Predicate { "".equals(planViable.codigo_plan) })
                .flatMap { planViableRequest -> crearPlanViable(planViableRequest.id_usuario)
                        .flatMap { plan -> inversionService.guardarInversiones(planViable.inversiones, plan.codigoPlan)}}
    }

    fun crearObjetoPlanViableRespuesta(inversiones: List<Inversion>, planViable: PlanViable): Mono<PlanViableResponse> {
        return Mono.just(PlanViableResponse(inversiones, planViable));
    }

    fun crearPlanViable(idUsuario: String): Mono<PlanViable>{
        return Mono.just(PlanViable("5q2", idUsuario))
                .flatMap { planViable -> Mono.just(planViableRepository.save(planViable)) }
    }

}