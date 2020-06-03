package com.pve.pvebackend.model.fianciacion

import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Data
import javax.persistence.*

@Data
@AllArgsConstructor
@Builder(toBuilder = true)
@Entity
@Table(name = "devolucion_prestamo")
class DevolucionPrestamo() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int = 0
    var codigoProyecto: String = ""
    var tiempo: String = ""
    var prestamo0: Int = 0
    var prestamo1: Int = 0
    var prestamo2: Int = 0
    var prestamo3: Int = 0
    var prestamo4: Int = 0
    var prestamo5: Int = 0
    var totalPrestamo: Int = 0

    constructor(id: Int, codigoProyecto: String, tiempo: String, prestamo0: Int, prestamo1: Int, prestamo2: Int, prestamo3: Int, prestamo4: Int, prestamo5: Int, totalPrestamo: Int) : this() {
        this.id = id
        this.codigoProyecto = codigoProyecto
        this.tiempo = tiempo
        this.prestamo0 = prestamo0
        this.prestamo1 = prestamo1
        this.prestamo2 = prestamo2
        this.prestamo3 = prestamo3
        this.prestamo4 = prestamo4
        this.prestamo5 = prestamo5
        this.totalPrestamo = totalPrestamo
    }
}