package com.pve.pvebackend.model.planViable

import com.pve.pvebackend.model.calculosIntermedios.CalculoIntermedio
import com.pve.pvebackend.model.inversion.Inversion
import com.pve.pvebackend.model.presupuesto.Presupuesto
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "plan_viable")
class PlanViable() {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Int = 0
    var codigoPlan: String = ""
    var idUsuario: String = ""
    var fechaCreacion: Date = Date()

}