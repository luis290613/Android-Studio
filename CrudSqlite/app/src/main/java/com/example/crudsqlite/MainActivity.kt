package com.example.crudsqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.crudsqlite.adaptadores.adaptadorRecycler
import com.example.crudsqlite.databinding.ActivityMainBinding
import com.example.crudsqlite.modelo.Personaje

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //v-c
        var recyclerView : RecyclerView =  binding.recycleePrincipal

        //delegado  -> requireActivity lo utilizamos para obtener el contexto desde el activity padre
        recyclerView.layoutManager = LinearLayoutManager(this)
        val ListaPokemon : MutableList<Personaje> = mutableListOf()
        ListaPokemon.add(Personaje(10,"luis","ruiz bautista",Personaje.TypeSexo.hombre))
        ListaPokemon.add(Personaje(10,"geral","tineo saavedra",Personaje.TypeSexo.mujer))
        ListaPokemon.add(Personaje(10,"pepito","pruebaa",Personaje.TypeSexo.cabrilla))


        //asignamos el adapter personalizado
        var adapter = adaptadorRecycler()
        recyclerView.adapter = adapter
        adapter.submitList(ListaPokemon)

        adapter.onItemClickListener = {

            //pintar datos para el click
            Toast.makeText(this,it.nombre,Toast.LENGTH_LONG).show()
        }

    }


}