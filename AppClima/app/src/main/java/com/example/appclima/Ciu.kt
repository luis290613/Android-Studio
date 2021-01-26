package com.example.appclima

class Ciu {
    var nombre : String = ""
    var grados : Int = 0
    var estatus : String = ""

    constructor(){

    }
    constructor(nombre : String, grados : Int, estatus : String){
        this.nombre = nombre
        this.grados = grados
        this.estatus = estatus
    }
}