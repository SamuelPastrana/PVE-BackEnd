package com.pve.pvebackend.model.inversion

import javax.persistence.*

@Entity
@Table(name = "inversion")
class Inversion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Int = 0
    var codigoPlan: String = ""
    var tiempo: String = ""
    var infraMaquinas: Int = 0
    var mobiliario: Int = 0
    var otros: Int = 0
    var equiposInformaticos: Int = 0
    var vehiculos: Int = 0
    var totalNoCorriente: Int = 0
    var existenciasIniciales: Int = 0
    var liquidez: Int = 0
    var totalCorriente: Int = 0
    var totalInversion: Int = 0

}