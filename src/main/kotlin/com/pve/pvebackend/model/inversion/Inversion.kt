package com.pve.pvebackend.model.inversion

import javax.persistence.*

@Entity
@Table(name = "inversion")
class Inversion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private val id = 0;

    @Column(name = "inversionCode")
    val inversionCode = 0;
    val inversionNumber = 0;
    private val infraMaquinas = 0;
    private val equiposInformaticos = 0;
    private val vehiculos = 0;
    private val totalNoCorriente = 0;
    private val existenciasIniciales = 0;
    private val liquidez = 0;
    private val totalCorriente = 0;
    private val totalInversion = 0;

}