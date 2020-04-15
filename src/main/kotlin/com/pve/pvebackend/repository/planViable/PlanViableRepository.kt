package com.pve.pvebackend.repository.planViable

import com.pve.pvebackend.model.planViable.PlanViable
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono

@Repository
interface PlanViableRepository: CrudRepository<PlanViable, Int> {
    fun findPlanViableByIdUsuario(idUsuario: String): PlanViable
    fun findPlanViableByCodigoPlan(codigo: String): PlanViable
}