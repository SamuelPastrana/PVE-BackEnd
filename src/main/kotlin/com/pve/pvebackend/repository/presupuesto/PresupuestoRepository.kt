package com.pve.pvebackend.repository.presupuesto

import com.pve.pvebackend.model.inversion.Inversion
import com.pve.pvebackend.model.presupuestos.Presupuesto
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository


@Repository
interface PresupuestoRepository: CrudRepository <Presupuesto, Long> {
    fun findPresupuestoByCodigoProyecto(codigo_proyecto: String): List<Presupuesto>
    fun findPresupuestoById(id: Int): Presupuesto
}