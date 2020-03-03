package com.pve.pvebackend.repository.inversion

import com.pve.pvebackend.model.inversion.Inversion
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface InversionRepository: CrudRepository<Inversion, Long>{

    override fun findAll(): List<Inversion>
}