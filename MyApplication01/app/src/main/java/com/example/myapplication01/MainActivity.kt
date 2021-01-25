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
        //sentenciaWhen()
        //arreglos()
        //maps()
        //bucles()
        //funciones()
        clases()
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
    fun arreglos(){
        val nombre = "diego"
        val apellido = "ruiz bautista"
        val carrera = "sistemas"
        val metas = "ingeniero"
        val metas1 = "familia"

        var arregloDatos : ArrayList<String> = arrayListOf<String>()

        //añadir datos a un array
        arregloDatos.add(nombre)
        arregloDatos.add(apellido)
        arregloDatos.add(carrera)

        println(arregloDatos)

        //añadir datos en conjunto
        arregloDatos.addAll(listOf(metas,metas1))
        println(arregloDatos)

        //acceso de datos por posicion
        println(arregloDatos[1])

        //modificar datos
        arregloDatos[1] = "cambiando por otro apellido"
        println(arregloDatos)

        //eliminar datos
        arregloDatos.removeAt(1)
        println(arregloDatos)

        //recorrer arreglo con foreach
        arregloDatos.forEach{
            println(it)
        }

        //otras opciones
        println(arregloDatos.count())
        arregloDatos.clear()
        println("deberia de ser 0 -> ${arregloDatos.count()}")

    }
    //hablaremos de mapas o tambien lalamados diccionarios
    fun maps(){

        //sintaxis de creacion de mapas o diccionarios
        var myMaps : Map<String,Int> = mapOf()
        println(myMaps)

        //añadir elemenos
        myMaps = mutableMapOf("key1" to 1, "key2" to 2, "key3" to 3)
        println(myMaps)

        //añadir un solo valor
        myMaps["key4"] = 4
        myMaps.put("key5",5)

        //SI AGREGAS CON EL MISMO KEY PS LO MODIFICARA
        myMaps.put("key1",10)

        //acceder a un valor
        println(myMaps["key1"])
    }
    //ciclos repeptitivos
    fun bucles(){
        val myArray : List<String> = listOf("hola","prueba","sigueinte prueba")
        val myMap : MutableMap<String,Int> = mutableMapOf("key1" to 1,"key2" to 2, "key3" to 3)

        //ciclo for

        for (item in myArray) {
            println(item)
        }
        for (item in myMap) {
            println("${item.key} ,${item.value}")
        }
        //clasico
        for (x in 0..10){
            println(x)
        }
        //no imprime el ultimo
        for (x in 0 until 10){
            println(x)
        }
        //salto de 2 en 2 o el numero que se le indique después del step
        for (x in 0..10 step 2){
            println(x)
        }
        //en retro
        for (x in 10 downTo 0 step 2){
            println(x)
        }
        //creando array de rango numerico
        val myNumberArrayNumerico : IntRange = (0..20)
        for (i in myNumberArrayNumerico) {
                println(i)
        }
    }
    fun clases(){
        val Diego = Programador("diego",apellido = "ruiz baurtista", edad = 23, lenguajes = arrayOf(Programador.Lenguajes.java,Programador.Lenguajes.swift))
        println(Diego.code())
    }
}