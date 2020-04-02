package com.pve.pvebackend.model.planViable

import com.pve.pvebackend.model.calculosIntermedios.CalculoIntermedio
import com.pve.pvebackend.model.inversion.Inversion
import com.pve.pvebackend.model.financiacion.Financiacion
import java.util.*

class PlanViableResponse(inversiones: List<Inversion>, planViable: PlanViable) {
    var codigo_plan: String = planViable.codigoPlan
    var id_usuario: String = planViable.idUsuario
    var fecha_creacion: Date = planViable.fechaCreacion
    var inversiones: List<Inversion> = inversiones
    var calculos_intermedios: List<CalculoIntermedio> = listOf(CalculoIntermedio())
    var presupuestos: List<Financiacion> = listOf(Financiacion())
}