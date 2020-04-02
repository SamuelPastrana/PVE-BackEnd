package com.pve.pvebackend.model.inversion

import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Data
import lombok.NoArgsConstructor
import javax.persistence.*

@Data
@AllArgsConstructor
@Builder(toBuilder = true)
@Entity
@Table(name = "inversion")
class Inversion() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    constructor(codigoPlan: String, tiempo: String, infraMaquinas: Int, mobiliario: Int, otros: Int, equiposInformaticos: Int, vehiculos: Int, totalNoCorriente: Int, existenciasIniciales: Int, liquidez: Int, totalCorriente: Int, totalInversion: Int) : this() {
        this.codigoPlan = codigoPlan
        this.tiempo = tiempo
        this.infraMaquinas = infraMaquinas
        this.mobiliario = mobiliario
        this.otros = otros
        this.equiposInformaticos = equiposInformaticos
        this.vehiculos = vehiculos
        this.totalNoCorriente = totalNoCorriente
        this.existenciasIniciales = existenciasIniciales
        this.liquidez = liquidez
        this.totalCorriente = totalCorriente
        this.totalInversion = totalInversion
    }

}