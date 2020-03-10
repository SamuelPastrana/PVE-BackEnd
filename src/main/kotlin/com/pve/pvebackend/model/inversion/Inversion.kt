package com.pve.pvebackend.model.inversion

import javax.persistence.*

@Entity
@Table(name = "inversion")
class Inversion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Int = 0
    var inversion_code: String = "";
    var usuario: String = "";
    var infra_maquinas: Int = 0;
    var equipos_informaticos: Int = 0;
    var vehiculos: Int = 0;
    var total_no_corriente: Int = 0;
    var existencias_iniciales: Int = 0;
    var liquidez: Int = 0;
    var total_corriente: Int = 0;
    var total_inversion: Int = 0;

}