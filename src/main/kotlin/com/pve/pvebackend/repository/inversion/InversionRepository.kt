package com.pve.pvebackend.repository.inversion

import com.pve.pvebackend.model.inversion.Inversion
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Repository
interface InversionRepository: CrudRepository<Inversion, Int>{

    fun findInversionById(id: Int): Mono<Inversion>;
    fun findInversionByUsuario(nombre: String): Flux<Inversion>;
    //fun findInversionByInversion_code(codigo: String): List<Inversion>
}