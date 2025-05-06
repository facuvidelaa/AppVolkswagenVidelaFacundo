package com.example.parcial_facundovidela

data class Vehiculos(
    val id: Int,
    val marca: String,
    val modelo: String,
    val potencia: Int,         // en HP o CV
    val velocidadMax: Int,     // en km/h
    val tipo: TipoVehiculo,
    val url: String
)

enum class TipoVehiculo {
    PICKUP, SUV, SEDAN, COMPACTOS, DEPORTIVO
}
