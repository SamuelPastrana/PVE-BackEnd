package com.pve.pvebackend.services.inversion

import com.pve.pvebackend.model.inversion.Inversion
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

    override fun obtenerInversionesPorCodigoPlan(codigo: String): Flux<Inversion> {
        return Flux.fromIterable(repository.findInversionByCodigoPlan(codigo))
    }

    override fun guardarInversiones(inversiones: List<Inversion>, codigoPlan: String): Mono<Void> {
        return Flux.fromIterable(inversiones)
                .map { inversion -> inversion }
                .flatMap { inversion ->
                    crearInversion(inversion, codigoPlan)
                            .flatMap { inversionNew -> Mono.just(repository.save(inversionNew)) }
                }
                .then()
    }

    fun crearInversion(inversion: Inversion, codigoPlan: String): Mono<Inversion> {
        return Mono.just(Inversion(codigoPlan, inversion.tiempo, inversion.infraMaquinas, inversion.mobiliario,
                inversion.otros, inversion.equiposInformaticos, inversion.vehiculos, inversion.totalNoCorriente,
                inversion.existenciasIniciales, inversion.liquidez, inversion.totalCorriente, inversion.totalInversion))
    }

}

