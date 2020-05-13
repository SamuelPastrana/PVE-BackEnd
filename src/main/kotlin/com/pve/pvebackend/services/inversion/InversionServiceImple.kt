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

    override fun obtenerInversionPorId(id: Int): Mono<Inversion> {
        return Mono.just(repository.findInversionById(id))

    }

    override fun obtenerInversionesPorCodigoProyecto(codigo: String): Flux<Inversion> {
        return Flux.fromIterable(repository.findInversionByCodigoProyecto(codigo))
    }

    override fun guardarInversiones(inversiones: List<Inversion>): Mono<Void> {
        return Flux.fromIterable(inversiones)
                .flatMap { inversion ->
                    crearInversion(inversion)
                            .flatMap { inversionData -> Mono.just(repository.save(inversionData)) }
                }.then()
    }

    fun crearInversion(inversion: Inversion): Mono<Inversion> {
        return if (inversion.id > 0) {
            Mono.just(Inversion(inversion.id, inversion.codigoProyecto, inversion.tiempo, inversion.infraMaquinas, inversion.mobiliario,
                    inversion.otros, inversion.equiposInformaticos, inversion.vehiculos, inversion.totalNoCorriente,
                    inversion.existenciasIniciales, inversion.liquidez, inversion.totalCorriente, inversion.totalInversion))
        } else {
            Mono.just(Inversion(0, inversion.codigoProyecto, inversion.tiempo, inversion.infraMaquinas, inversion.mobiliario,
                    inversion.otros, inversion.equiposInformaticos, inversion.vehiculos, inversion.totalNoCorriente,
                    inversion.existenciasIniciales, inversion.liquidez, inversion.totalCorriente, inversion.totalInversion))
        }
    }
}

