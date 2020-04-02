package com.pve.pvebackend.model.planViable

import com.pve.pvebackend.model.calculosIntermedios.CalculoIntermedio
import com.pve.pvebackend.model.financiacion.Financiacion
import com.pve.pvebackend.model.inversion.Inversion
import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Data
import lombok.NoArgsConstructor
import java.util.*

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
class PlanViableRequest {
    var codigo_plan: String = ""
    var id_usuario: String = ""
    var fecha_creacion: Date? = null
    var inversiones: List<Inversion> = listOf(Inversion())
    var calculos_intermedios: List<CalculoIntermedio> = listOf(CalculoIntermedio())
    var financiacion: List<Financiacion> = listOf(Financiacion())
}