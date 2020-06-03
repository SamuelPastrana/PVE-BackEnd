package com.pve.pvebackend.repository.financiacion

import com.pve.pvebackend.model.fianciacion.DevolucionPrestamo
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface DevolucionPrestamoRepository: CrudRepository<DevolucionPrestamo, Long> {
    fun findDevolucionPrestamoByCodigoProyecto(codigo: String): List<DevolucionPrestamo>
}