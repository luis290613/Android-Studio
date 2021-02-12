package com.example.crudsqlite.DAO

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.crudsqlite.modelo.Personaje
//consultas al sqlite por medio de estas funciones que se encuentran en una interface
@Dao
interface PersonasDao {

    @Query("SELECT * FROM Personas")
    fun getAll(): LiveData<List<Personaje>>

    @Query("SELECT * FROM personas WHERE nombre = :nombre")
    fun get(nombre : String) : LiveData<Personaje>

    @Insert()
    fun insertAll(vararg Persona : Personaje)

    @Update()
    fun update(persona : Personaje)
}