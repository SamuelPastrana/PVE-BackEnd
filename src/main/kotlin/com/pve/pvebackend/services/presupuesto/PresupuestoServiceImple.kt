package com.pve.pvebackend.services.presupuesto

import com.pve.pvebackend.model.inversion.Inversion
import com.pve.pvebackend.model.presupuestos.Presupuesto
import com.pve.pvebackend.repository.presupuesto.PresupuestoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class PresupuestoServiceImple : PresupuestoService {

    @Autowired
    lateinit var repository: PresupuestoRepository

    override fun obtenerInversionesPorCodigoPlan(codigo: String): List<Presupuesto> {
        return repository.findPresupuestoByCodigoPlan(codigo)
    }

    override fun obtenerInversionesPorCodigo(id: Int): Mono<Presupuesto> {
        return Mono.just(repository.findPresupuestoById(id))

    }

    override fun guardarPresupuestos(presupuestos: List<Presupuesto>, codigoPlan: String): Mono<Void> {

        if (presupuestos.isNotEmpty() && "" != presupuestos.get(0).codigoPlan) {
            return Flux.fromIterable(presupuestos)
                    .flatMap { presupuesto ->
                        obtenerInversionesPorCodigo(presupuesto.id)
                                .flatMap { presupuestoDb ->
                                    crearPresupuesto(presupuesto, presupuestoDb.codigoPlan)
                                            .flatMap { inversionNew -> Mono.just(repository.save(inversionNew)) }
                                }
                    }
                    .then()
        } else {
            return Flux.fromIterable(presupuestos)
                    .map { presupuesto -> presupuesto }
                    .flatMap { presupuesto ->
                        crearPresupuesto(presupuesto, codigoPlan)
                                .flatMap { presupuestoNew -> Mono.just(repository.save(presupuestoNew)) }
                    }
                    .then()
        }

    }

    fun crearPresupuesto(presupuesto: Presupuesto, codigoPlan: String): Mono<Presupuesto> {
        return Mono.just(Presupuesto(presupuesto.id, codigoPlan, presupuesto.tiempo, presupuesto.ahorros, presupuesto.prestamoFamilia,
                presupuesto.otros, presupuesto.recursosPropios, presupuesto.premios, presupuesto.intercambios, presupuesto.cursos, presupuesto.financiacionCoste))
    }

}