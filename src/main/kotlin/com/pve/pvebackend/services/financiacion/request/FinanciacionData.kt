package com.pve.pvebackend.services.financiacion.request

import com.pve.pvebackend.model.fianciacion.CapitalVivo
import com.pve.pvebackend.model.fianciacion.DevolucionPrestamo
import com.pve.pvebackend.model.fianciacion.Financiacion
import com.pve.pvebackend.model.fianciacion.GastosFinanciero

class FinanciacionData() {
    lateinit var financiacion: List<Financiacion>
    lateinit var capitalVivo: List<CapitalVivo>
    lateinit var gastosFinancieros: List<GastosFinanciero>
    lateinit var devolucionPrestamos: List<DevolucionPrestamo>

    constructor(financiacion: List<Financiacion>, capitalVivo: List<CapitalVivo>, gastosFinancieros: List<GastosFinanciero>, devolucionPrestamos: List<DevolucionPrestamo>) : this() {
        this.financiacion = financiacion
        this.capitalVivo = capitalVivo
        this.gastosFinancieros = gastosFinancieros
        this.devolucionPrestamos = devolucionPrestamos
    }
}