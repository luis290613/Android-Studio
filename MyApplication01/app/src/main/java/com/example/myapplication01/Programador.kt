package com.example.myapplication01

class Programador(var nombre : String,var apellido : String ,var edad : Int,var lenguajes : Array<Lenguajes>) {

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
        for (lenguaje in lenguajes) {
            mensaje += "$lenguaje, "
        }
        return mensaje
    }
}