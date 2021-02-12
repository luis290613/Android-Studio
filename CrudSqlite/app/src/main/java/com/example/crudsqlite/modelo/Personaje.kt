package com.example.crudsqlite.modelo

import androidx.room.Entity
import java.io.Serializable

//ESTA CLASE ES LA REPRESENTACION DE UNA TABLA EN SQLITE

@Entity(tableName = "Personas")
data class Personaje(var id : Int,var nombre : String,var apellido : String,var sexo : TypeSexo) : Serializable{

    enum class TypeSexo{
        hombre, mujer, cabrilla
    }
}