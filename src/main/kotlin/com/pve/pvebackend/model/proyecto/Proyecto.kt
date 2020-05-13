package com.pve.pvebackend.model.proyecto

import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Data
import java.util.*
import javax.persistence.*

@Data
@AllArgsConstructor
@Builder(toBuilder = true)
@Entity
@Table(name = "proyecto")
class Proyecto() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int = 0
    var codigoProyecto: String = ""
    var nombre: String = ""
    var descripcion: String = ""
    var logo: String = ""
    var fecha_creacion: Date? = null
    var idUsuario: String = ""

    constructor(id: Int, codigo_proyecto: String, nombre: String, descripcion: String, logo: String, fecha_creacion: Date?, id_usuario: String) : this() {
        this.id = id
        this.codigoProyecto = codigo_proyecto
        this.nombre = nombre
        this.descripcion = descripcion
        this.logo = logo
        this.fecha_creacion = fecha_creacion
        this.idUsuario = id_usuario
    }
}