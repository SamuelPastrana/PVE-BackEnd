package com.pve.pvebackend.model.planViable

import com.pve.pvebackend.model.calculosIntermedios.CalculoIntermedio
import com.pve.pvebackend.model.inversion.Inversion
import com.pve.pvebackend.model.presupuestos.Presupuesto
import java.time.Instant
import java.time.ZonedDateTime
import java.util.*

class PlanViableResponse(planViable: PlanViable, inversiones: List<Inversion>, presupuestos: List<Presupuesto>) {
    var codigo_plan: String = planViable.codigoPlan
    var id_usuario: String = planViable.idUsuario
    var fecha_creacion: ZonedDateTime = planViable.fechaCreacion
    var inversiones: List<Inversion> = inversiones
    var calculos_intermedios: List<CalculoIntermedio> = listOf(CalculoIntermedio())
    var presupuestos: List<Presupuesto> = presupuestos
}