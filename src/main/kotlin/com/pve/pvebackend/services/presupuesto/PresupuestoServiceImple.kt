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

    override fun obtenerPresupuestosPorCodigoProyecto(codigo: String): Flux<Presupuesto> {
        return Flux.fromIterable(repository.findPresupuestoByCodigoProyecto(codigo))
    }

    override fun obtenerInversionesPorId(id: Int): Mono<Presupuesto> {
        return Mono.just(repository.findPresupuestoById(id))

    }

    override fun guardarPresupuestos(presupuestos: List<Presupuesto>): Mono<Void> {
        return Flux.fromIterable(presupuestos)
                .flatMap { prespuesto ->
                    crearPresupuesto(prespuesto)
                            .flatMap { presupuestoData -> Mono.just(repository.save(presupuestoData)) }
                }.then()
    }

    fun crearPresupuesto(presupuesto: Presupuesto): Mono<Presupuesto> {
        return if (presupuesto.id > 0) {
            Mono.just(Presupuesto(presupuesto.id, presupuesto.codigoProyecto, presupuesto.tiempo, presupuesto.ahorros,
                    presupuesto.prestamoFamilia, presupuesto.otros, presupuesto.recursosPropios, presupuesto.premios, presupuesto.intercambios, presupuesto.cursos,
                    presupuesto.financiacionCoste))
        } else {
            Mono.just(Presupuesto(0, presupuesto.codigoProyecto, presupuesto.tiempo, presupuesto.ahorros,
                    presupuesto.prestamoFamilia, presupuesto.otros, presupuesto.recursosPropios, presupuesto.premios, presupuesto.intercambios, presupuesto.cursos,
                    presupuesto.financiacionCoste))
        }
    }
}
