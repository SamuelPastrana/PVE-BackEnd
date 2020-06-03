package com.pve.pvebackend.repository.financiacion

import com.pve.pvebackend.model.fianciacion.Financiacion
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface FinanciacionRepository: CrudRepository<Financiacion, Long> {
    fun findFinanciacionByCodigoProyecto(codigoProyecto: String): List<Financiacion>
}