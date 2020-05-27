package com.pve.pvebackend.model.gastos

import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

class Gastos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Int = 0

}