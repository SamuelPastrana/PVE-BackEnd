package com.pve.pvebackend.model.planViable

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "plan_viable")
class PlanViable(var codigoPlan: String, var idUsuario: String) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Int = 0
    var fechaCreacion: Date = Date()

}