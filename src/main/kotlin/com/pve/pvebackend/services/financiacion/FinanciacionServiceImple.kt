package com.pve.pvebackend.services.financiacion

import com.pve.pvebackend.model.fianciacion.CapitalVivo
import com.pve.pvebackend.model.fianciacion.DevolucionPrestamo
import com.pve.pvebackend.model.fianciacion.Financiacion
import com.pve.pvebackend.model.fianciacion.GastosFinanciero
import com.pve.pvebackend.repository.financiacion.CapitalVivoRepository
import com.pve.pvebackend.repository.financiacion.DevolucionPrestamoRepository
import com.pve.pvebackend.repository.financiacion.FinanciacionRepository
import com.pve.pvebackend.repository.financiacion.GastosFinancierosRepository
import com.pve.pvebackend.services.financiacion.request.FinanciacionData
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class FinanciacionServiceImple : FinanciacionService {

    @Autowired
    lateinit var financiacionRepository: FinanciacionRepository

    @Autowired
    lateinit var capitalVivoRepository: CapitalVivoRepository

    @Autowired
    lateinit var gastosFinancierosRepository: GastosFinancierosRepository

    @Autowired
    lateinit var devolucionPrestamoRepository: DevolucionPrestamoRepository

    override fun obtenerFinanciacionPorCodigoProyecto(codigoProyecto: String): Mono<FinanciacionData> {
        return Mono.just(codigoProyecto)
                .map { codigo -> financiacionRepository.findFinanciacionByCodigoProyecto(codigo) }
                .zipWith(Mono.just(capitalVivoRepository.findCapitalVivoByCodigoProyecto(codigoProyecto)))
                .zipWith(Mono.just(gastosFinancierosRepository.findGastosFinancieroByCodigoProyecto(codigoProyecto)))
                .zipWith(Mono.just(devolucionPrestamoRepository.findDevolucionPrestamoByCodigoProyecto(codigoProyecto)))
                .flatMap { objects -> Mono.just(FinanciacionData(objects.t1.t1.t1, objects.t1.t1.t2, objects.t1.t2, objects.t2)) }
    }

    override fun guardarFinanciacion(financiacionData: FinanciacionData): Mono<Void> {

        return guardarFinan(financiacionData.financiacion)
                .then(guardarCapitalVivo(financiacionData.capitalVivo)
                        .then(guardarGastos(financiacionData.gastosFinancieros)
                                .then(guardarDevolucionPrestamos(financiacionData.devolucionPrestamos))))

        /* guardarGastos(financiacionData.gastosFinancieros)
         guardarDevolucionPrestamos(financiacionData.devolucionPrestamos)

         return Mono.empty()*/
        /*return Mono.just(financiacionData)
                .flatMap {
                    guardarFinan(financiacionData.financiacion)
                            .flatMap {
                                guardarCapitalVivo(financiacionData.capitalVivo)
                                        .flatMap {
                                            guardarGastos(financiacionData.gastosFinancieros)
                                                    .flatMap { guardarDevolucionPrestamos(financiacionData.devolucionPrestamos) }
                                        }
                            }

                }*/
    }

    private fun guardarDevolucionPrestamos(devolucionPrestamos: List<DevolucionPrestamo>): Mono<Void> {
        return Flux.fromIterable(devolucionPrestamos).flatMap { devolucionPrestamo ->
            crearDevolucionPrestamo(devolucionPrestamo).flatMap { devolucionPrestamoD -> Mono.just(devolucionPrestamoRepository.save(devolucionPrestamoD)) }
        }.then()
    }

    private fun guardarGastos(gastosFinancieros: List<GastosFinanciero>): Mono<Void> {
        return Flux.fromIterable(gastosFinancieros).flatMap { gastosFinanciero ->
            crearGastoFinanciero(gastosFinanciero).flatMap { gastosFinancieroD -> Mono.just(gastosFinancierosRepository.save(gastosFinancieroD)) }
        }.then()
    }

    private fun guardarCapitalVivo(capitalVivo: List<CapitalVivo>): Mono<Void> {
        return Flux.fromIterable(capitalVivo).flatMap {
            crearCapitarVivo(it).flatMap { capitalVivoD -> Mono.just(capitalVivoRepository.save(capitalVivoD)) }
        }.then()
    }

    private fun guardarFinan(financiacion: List<Financiacion>): Mono<Void> {
        return Flux.fromIterable(financiacion)
                .flatMap {
                    crearFinanciacion(it)
                            .flatMap { financiacionD -> Mono.just(financiacionRepository.save(financiacionD)) }
                }.then()
    }
}

private fun crearDevolucionPrestamo(devolucionPrestamo: DevolucionPrestamo): Mono<DevolucionPrestamo> {
    return if (devolucionPrestamo.id > 0) {
        Mono.just(DevolucionPrestamo(devolucionPrestamo.id, devolucionPrestamo.codigoProyecto, devolucionPrestamo.tiempo, devolucionPrestamo.prestamo0, devolucionPrestamo.prestamo1, devolucionPrestamo.prestamo2, devolucionPrestamo.prestamo3, devolucionPrestamo.prestamo4, devolucionPrestamo.prestamo5, devolucionPrestamo.totalPrestamo))
    } else {
        Mono.just(DevolucionPrestamo(0, devolucionPrestamo.codigoProyecto, devolucionPrestamo.tiempo, devolucionPrestamo.prestamo0, devolucionPrestamo.prestamo1, devolucionPrestamo.prestamo2, devolucionPrestamo.prestamo3, devolucionPrestamo.prestamo4, devolucionPrestamo.prestamo5, devolucionPrestamo.totalPrestamo))
    }
}

private fun crearGastoFinanciero(gastosFinanciero: GastosFinanciero): Mono<GastosFinanciero> {
    return if (gastosFinanciero.id > 0) {
        Mono.just(GastosFinanciero(gastosFinanciero.id, gastosFinanciero.codigoProyecto, gastosFinanciero.tiempo, gastosFinanciero.prestamo0, gastosFinanciero.prestamo1, gastosFinanciero.prestamo2, gastosFinanciero.prestamo3, gastosFinanciero.prestamo4, gastosFinanciero.prestamo5, gastosFinanciero.totalPrestamo))
    } else {
        Mono.just(GastosFinanciero(0, gastosFinanciero.codigoProyecto, gastosFinanciero.tiempo, gastosFinanciero.prestamo0, gastosFinanciero.prestamo1, gastosFinanciero.prestamo2, gastosFinanciero.prestamo3, gastosFinanciero.prestamo4, gastosFinanciero.prestamo5, gastosFinanciero.totalPrestamo))
    }
}

private fun crearCapitarVivo(capitalVivo: CapitalVivo): Mono<CapitalVivo> {
    return if (capitalVivo.id > 0) {
        Mono.just(CapitalVivo(capitalVivo.id, capitalVivo.codigoProyecto, capitalVivo.tiempo, capitalVivo.prestamo0, capitalVivo.prestamo1, capitalVivo.prestamo2, capitalVivo.prestamo3, capitalVivo.prestamo4, capitalVivo.prestamo5, capitalVivo.totalPrestamo))
    } else {
        Mono.just(CapitalVivo(0, capitalVivo.codigoProyecto, capitalVivo.tiempo, capitalVivo.prestamo0, capitalVivo.prestamo1, capitalVivo.prestamo2, capitalVivo.prestamo3, capitalVivo.prestamo4, capitalVivo.prestamo5, capitalVivo.totalPrestamo))
    }
}

private fun crearFinanciacion(financiacion: Financiacion): Mono<Financiacion> {
    return if (financiacion.id > 0) {
        Mono.just(Financiacion(financiacion.id, financiacion.codigoProyecto, financiacion.tiempo, financiacion.pptoEmprendedor,
                financiacion.prestamos, financiacion.tipoInteres, financiacion.anios, financiacion.totalFinaciacion, financiacion.inversion, financiacion.financiacion))
    } else {
        Mono.just(Financiacion(0, financiacion.codigoProyecto, financiacion.tiempo, financiacion.pptoEmprendedor,
                financiacion.prestamos, financiacion.tipoInteres, financiacion.anios, financiacion.totalFinaciacion, financiacion.inversion, financiacion.financiacion))
    }
}