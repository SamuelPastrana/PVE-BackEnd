package com.pve.pvebackend.repository.financiacion

import com.pve.pvebackend.model.fianciacion.CapitalVivo
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CapitalVivoRepository: CrudRepository<CapitalVivo, Long> {
    fun findCapitalVivoByCodigoProyecto(codigo: String): List<CapitalVivo>
}