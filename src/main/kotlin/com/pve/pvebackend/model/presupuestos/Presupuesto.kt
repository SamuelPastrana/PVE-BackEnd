package com.pve.pvebackend.model.presupuestos

import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Data
import javax.persistence.*

@Data
@AllArgsConstructor
@Builder(toBuilder = true)
@Entity
@Table(name = "presupuesto")
class Presupuesto() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int = 0
    var codigoProyecto: String = ""
    var tiempo: String = ""
    var ahorros: Int = 0
    var prestamoFamilia: Int = 0
    var otros: Int = 0
    var recursosPropios: Int = 0
    var premios: Int = 0
    var intercambios: Int = 0
    var cursos: Int = 0
    var financiacionCoste: Int = 0

    constructor(id: Int, codigoProyecto: String, tiempo: String, ahorros: Int, prestamoFamilia: Int, otros: Int, recursosPropios: Int, premios: Int, intercambios: Int, cursos: Int, financiacionCoste: Int) : this() {
        this.id = id
        this.codigoProyecto = codigoProyecto
        this.tiempo = tiempo
        this.ahorros = ahorros
        this.prestamoFamilia = prestamoFamilia
        this.otros = otros
        this.recursosPropios = recursosPropios
        this.premios = premios
        this.intercambios = intercambios
        this.cursos = cursos
        this.financiacionCoste = financiacionCoste
    }
}