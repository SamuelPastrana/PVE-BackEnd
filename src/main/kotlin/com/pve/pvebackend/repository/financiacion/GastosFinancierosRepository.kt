package com.pve.pvebackend.repository.financiacion

import com.pve.pvebackend.model.fianciacion.GastosFinanciero
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface GastosFinancierosRepository: CrudRepository<GastosFinanciero, Long> {
    fun findGastosFinancieroByCodigoProyecto(codigo: String): List<GastosFinanciero>
}