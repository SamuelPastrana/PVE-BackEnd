package com.pve.pvebackend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PveBackendApplication

fun main(args: Array<String>) {
	runApplication<PveBackendApplication>(*args)
}
