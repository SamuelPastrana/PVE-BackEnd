package com.pve.pvebackend.model.planViable


import java.sql.Date
import java.time.Instant
import java.time.ZonedDateTime
import java.util.*
import java.util.Calendar.*
import javax.persistence.*

@Entity
@Table(name = "plan_viable")
class PlanViable(var codigoPlan: String, var idUsuario: String) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Int = 0
    var fechaCreacion: ZonedDateTime = ZonedDateTime.now()

}