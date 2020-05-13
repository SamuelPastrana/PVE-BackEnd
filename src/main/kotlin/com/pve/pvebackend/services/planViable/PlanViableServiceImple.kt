package com.pve.pvebackend.services.planViable

import com.pve.pvebackend.exceptions.ExcepcionNegocio
import com.pve.pvebackend.helpers.GenerateUniqueCodeProyecto
import com.pve.pvebackend.model.inversion.Inversion
import com.pve.pvebackend.model.planViable.PlanViable
import com.pve.pvebackend.model.planViable.PlanViableRequest
import com.pve.pvebackend.model.planViable.PlanViableResponse
import com.pve.pvebackend.model.presupuestos.Presupuesto
import com.pve.pvebackend.model.proyecto.Proyecto
import com.pve.pvebackend.repository.inversion.InversionRepository
import com.pve.pvebackend.repository.planViable.PlanViableRepository
import com.pve.pvebackend.services.inversion.InversionService
import com.pve.pvebackend.services.presupuesto.PresupuestoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.*
import java.util.function.Predicate

@Service
class PlanViableServiceImple : PlanViableService, GenerateUniqueCodeProyecto {

    @Autowired
    lateinit var planViableRepository: PlanViableRepository

    override fun obtenerProyectosPorUsuario(usuario: String): Flux<Proyecto> {
        return Flux.fromIterable(planViableRepository.findProyectoByIdUsuario(usuario));
    }

    override fun obtenerProyectoPorCodigo(codigo: String): Mono<Proyecto> {
        return Mono.just(planViableRepository.findProyectoByCodigoProyecto(codigo))
    }

    override fun guardarProyecto(proyecto: Proyecto): Mono<Proyecto> {
        return Mono.just(proyecto)
                .filter { "" != proyecto.idUsuario }
                .flatMap { proyectoCrear -> crearProyecto(proyectoCrear) }
                .flatMap { proyectGuardar -> Mono.just(planViableRepository.save(proyectGuardar)) }
                .switchIfEmpty(Mono.error(ExcepcionNegocio("No se pudo guardar el proyecto")))
    }

    fun crearProyecto(proyecto: Proyecto): Mono<Proyecto> {
        val codigoProyecto = generateCodigoProyecto()
        var proyectoDb: Proyecto? = null;

        if (proyecto.codigoProyecto != "")
            proyectoDb = planViableRepository.findProyectoByCodigoProyecto(proyecto.codigoProyecto)
        return if (proyectoDb == null) {
            Mono.just(Proyecto(0, codigoProyecto.toString(), proyecto.nombre, proyecto.descripcion, proyecto.logo, Date(), proyecto.idUsuario))
                    .flatMap { planVi -> Mono.just(planViableRepository.save(planVi)) }
        } else {
            Mono.just(Proyecto(proyecto.id, proyecto.codigoProyecto, proyecto.nombre, proyecto.descripcion, proyecto.logo, proyecto.fecha_creacion, proyecto.idUsuario))
        }

    }

}