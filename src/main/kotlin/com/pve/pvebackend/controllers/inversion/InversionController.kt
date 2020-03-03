package com.pve.pvebackend.controllers.inversion

import com.pve.pvebackend.model.inversion.Inversion
import com.pve.pvebackend.services.inversion.IServiceInversion
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api_pve")
@CrossOrigin(value = ["*"], allowCredentials = "true")
class InversionController(@Autowired val iServiceInversion: IServiceInversion) {

    @GetMapping("/inversiones")
    fun getInveriones(): List<Inversion>{
        return iServiceInversion.obtenerInversiones();
    }

    @GetMapping("/inversion")
    fun getString(): String{
        return "Holaaa";
    }

}