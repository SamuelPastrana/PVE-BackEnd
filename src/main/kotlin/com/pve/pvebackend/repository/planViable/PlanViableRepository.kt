package com.pve.pvebackend.repository.planViable

import com.pve.pvebackend.model.proyecto.Proyecto
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono

@Repository
interface PlanViableRepository: CrudRepository<Proyecto, Int> {
    fun findProyectoByIdUsuario(id_usuario: String): List<Proyecto>
    fun findProyectoByCodigoProyecto(codigo: String): Proyecto
}