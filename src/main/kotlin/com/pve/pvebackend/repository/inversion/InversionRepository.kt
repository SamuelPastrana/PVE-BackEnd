package com.pve.pvebackend.repository.inversion

import com.pve.pvebackend.model.inversion.Inversion
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface InversionRepository: CrudRepository<Inversion, Long>{
    fun findInversionById(id: Int): Inversion;
    fun findInversionByCodigoPlan(codigo_plan: String): List<Inversion>;
}