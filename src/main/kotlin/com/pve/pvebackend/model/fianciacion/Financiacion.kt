package com.pve.pvebackend.model.fianciacion

import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Data
import javax.persistence.*

@Data
@AllArgsConstructor
@Builder(toBuilder = true)
@Entity
@Table(name = "financiacion")
class Financiacion() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int = 0
    var codigoProyecto: String = ""
    var tiempo: String = ""
    var pptoEmprendedor: String = ""
    var prestamos: Int = 0
    var tipoInteres: Int = 0
    var anios: Int = 0
    var totalFinaciacion: Int = 0
    var inversion: Int = 0
    var financiacion: Int = 0

    constructor(id: Int, codigoProyecto: String, tiempo: String, pptoEmprendedor: String, prestamos: Int, tipoInteres: Int, anios: Int, totalFinaciacion: Int, inversion: Int, financiacion: Int) : this() {
        this.id = id
        this.codigoProyecto = codigoProyecto
        this.tiempo = tiempo
        this.pptoEmprendedor = pptoEmprendedor
        this.prestamos = prestamos
        this.tipoInteres = tipoInteres
        this.anios = anios
        this.totalFinaciacion = totalFinaciacion
        this.inversion = inversion
        this.financiacion = financiacion
    }
}