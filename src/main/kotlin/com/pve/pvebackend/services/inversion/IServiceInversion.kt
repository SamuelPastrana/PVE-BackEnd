package com.pve.pvebackend.services.inversion

import com.pve.pvebackend.model.inversion.Inversion

interface IServiceInversion {
    fun obtenerInversiones(): List<Inversion>
}