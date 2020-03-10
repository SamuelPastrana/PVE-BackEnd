package com.pve.pvebackend.model.planViable

import com.pve.pvebackend.model.calculosIntermedios.CalculoIntermedio
import com.pve.pvebackend.model.inversion.Inversion
import com.pve.pvebackend.model.presupuesto.Presupuesto

class PlanViable(var inversiones: List<Inversion>) {

    var idUsuario: String = "123abc"
    var calculos_intermedios: List<CalculoIntermedio> = listOf(CalculoIntermedio())
    var presupuestos: List<Presupuesto> = listOf(Presupuesto())
}