package com.pve.pvebackend.services.planViable

import com.pve.pvebackend.exceptions.ExcepcionNegocio
import com.pve.pvebackend.helpers.GenerateUniqueCodePlan
import com.pve.pvebackend.model.inversion.Inversion
import com.pve.pvebackend.model.planViable.PlanViable
import com.pve.pvebackend.model.planViable.PlanViableRequest
import com.pve.pvebackend.model.planViable.PlanViableResponse
import com.pve.pvebackend.model.presupuestos.Presupuesto
import com.pve.pvebackend.repository.inversion.InversionRepository
import com.pve.pvebackend.repository.planViable.PlanViableRepository
import com.pve.pvebackend.services.inversion.InversionService
import com.pve.pvebackend.services.presupuesto.PresupuestoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.function.Predicate

@Service
class PlanViableServiceImple : PlanViableService, GenerateUniqueCodePlan {

    @Autowired
    lateinit var planViableRepository: PlanViableRepository

    @Autowired
    lateinit var inversionService: InversionService

    @Autowired
    lateinit var presupuestoService: PresupuestoService

    override fun obtenerPlanViablePorUsuario(usuario: String): Mono<PlanViableResponse> {
        try {
            return Mono.just(planViableRepository.findPlanViableByIdUsuario(usuario))
                    .flatMap { planViable ->
                        Mono.just(inversionService.obtenerInversionesPorCodigoPlan(planViable.codigoPlan))
                                .zipWith(Mono.just(presupuestoService.obtenerInversionesPorCodigoPlan(planViable.codigoPlan)))
                                .flatMap { objects -> crearObjetoPlanViableRespuesta(planViable, objects.t1, objects.t2) }
                    }
        } catch (e: EmptyResultDataAccessException) {
            return Mono.error(ExcepcionNegocio("Aun no tienes información registrada, crea tu primer plan viable"))
        }

    }

    override fun obteberPlanViablePorCodigoPlan(codigo: String): Mono<PlanViable> {
        return Mono.just(planViableRepository.findPlanViableByCodigoPlan(codigo))
    }

    override fun guardarPlanViableInformacion(planViable: PlanViableRequest): Mono<Void> {
        return Mono.just(planViable)
                .filter { "" != planViable.id_usuario }
                .flatMap { planViableRequest ->
                    crearPlanViable(planViableRequest.id_usuario, planViable.codigo_plan)
                            .flatMap { plan ->
                                inversionService.guardarInversiones(planViable.inversiones, plan.codigoPlan)
                                        .then(presupuestoService.guardarPresupuestos(planViable.presupuestos, planViable.codigo_plan))
                            }
                }
    }

    //Se esta duplucando el resgistro por que no se añade la informacion traida del back

    fun crearObjetoPlanViableRespuesta(planViable: PlanViable, inversiones: List<Inversion>, presupuestos: List<Presupuesto>): Mono<PlanViableResponse> {
        return Mono.just(PlanViableResponse(planViable, inversiones, presupuestos))
    }

    fun crearPlanViable(idUsuario: String, codigoPlanLlega: String): Mono<PlanViable> {
        val codigoPlan = generateCodigoPlan()
        var planViable: PlanViable? = null;

        if (codigoPlanLlega != "")
            planViable = planViableRepository.findPlanViableByCodigoPlan(codigoPlanLlega)
        return if (planViable == null) {
            Mono.just(PlanViable(codigoPlan.toString(), idUsuario))
                    .flatMap { planVi -> Mono.just(planViableRepository.save(planVi)) }
        } else {
            Mono.just(planViable)
        }

    }

}