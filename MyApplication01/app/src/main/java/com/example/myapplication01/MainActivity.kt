package com.example.myapplication01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //variableYConstante()
        //tiposDeDatos()
        //sentenciaIf()
        sentenciaWhen()
    }

    private fun variableYConstante(){
        //comentarios  -> barras inclinadas /**/ <- oro tipo de comentario

        //variables y constantes en kotlin
        var myNombre = "Diego" //usando camelCase
        var myFistVariable = "nombre de mi variable"
        myNombre = "nuevo valor"
        println(myNombre)

        //CONSTANTES
        val myFerstConstant = "me a gustado el tutorial"
        println(myFerstConstant)

    }

    private fun tiposDeDatos(){
        //variables y constantes fuertemente tipados

        //cadenas -> String
        var myString1 : String = "no es necesario especificar"
        var myString2 : String = "asdasdasd"
        //Int
        var myVariableInt = 1
        //Double
        var myVariableDouble = 1.0
        //Booleano
        var myVaribleBooleano = true

        //CONCATENACION
        var concatenacion = myString1 +" "+  myString2
        println(concatenacion)
    }
    fun sentenciaIf(){

        //condicionales igual que en cualquier otro tipo de lenguaje
        val myNumber = 20
        val myNombre = "Diego"
        //interpolacion parecido a js

        if (myNumber > 18 && myNombre == "Diego"){
            println("cumple los requisitos")
        }else{
            println("no cumple con los requisitos")
        }
    }
    fun sentenciaWhen(){
        //aqui vamos hablar de la sentencia when que es switch
        val country = "españaa"
        val edad = 50
        when(country){
            "españa" -> {
                println("el idioma es español")
            }
            "mexico" -> {
                println("el ididoma es perucho")
            }
            "brasil" -> {
                println("el idioma es brasileyurooo :V")
            }
            else -> {
                println("no tenemos ese pais weyy")
            }
        }
        //tambien podemos ejecutar con rango de edad y con signos mayor que menor que , ect.
        when(edad){
            0,1,2 -> {
                println("es un bebe")
            }
            in 10 .. 20 -> {
                println("esta entre dies y 20")
            }
            in 40 .. 60 -> {
                println("esta entre 40 y 60")
            }
            else -> {
                println("entro en el else")
            }
        }
    }



}