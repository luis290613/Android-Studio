package com.example.myapplication01
//ESTA ES UNA FORMA DE CREAR UNA CLASE PERO EN LA SIGUIENTE CLASE PERSONA LE MOSTRAREMOS OTRA FORMA
class Programador( nombre : String, apellido : String , edad : Int, lenguajes : Array<Programador.Lenguajes>) {
    var nombre = ""
    var apellido = ""
    var edad = 0
    var lenguajes : Array<Programador.Lenguajes>? = null

    init {
        this.nombre = nombre
        this.apellido = apellido
        this.edad = edad
        this.lenguajes = lenguajes

    }
    init {

    }
    enum class Lenguajes{
        kotlin,
        swift,
        java,
        php
    }
    fun code(): String{
       return  "mi nombres es $nombre y se los siguientes lenguajes : ${concatenaLenguajes()}"
    }
    fun concatenaLenguajes(): String{
        var mensaje = ""
        if (this.lenguajes != null){
            for (lenguaje in this.lenguajes!!) {
                mensaje += "$lenguaje, "
            }
        }else{
            mensaje = "naca la pelinaca"
        }

        return mensaje
    }
}