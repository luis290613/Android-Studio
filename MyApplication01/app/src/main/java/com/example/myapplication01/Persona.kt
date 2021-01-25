package com.example.myapplication01
//HERENCIA
open class Humano {
    var sexo : Boolean = false

}
class Persona : Humano{
    var nombre : String = ""
    var carrera : String? = "asdasd"

    constructor(nom : String, car:String? = "ninguna carrera"){
        this.nombre = nom
        this.carrera = car
    }
    constructor(){

    }
    fun ImprimiDatos() : String{
        return "Mi nombre es ${this.nombre} y estudio la carrera de ${this.carrera} y soy : $sexo"
    }
}