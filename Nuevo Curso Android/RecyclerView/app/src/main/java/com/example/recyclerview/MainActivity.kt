package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.Modelo.Eartquake
import com.example.recyclerview.adaptador.EqAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //vista-controlador
        var recycle = findViewById<RecyclerView>(R.id.idRecyclerView)
        fnConfigRecyclerView(recycle)
    }
    fun fnConfigRecyclerView(recycle : RecyclerView){
        // "delegado"
        recycle.layoutManager = LinearLayoutManager(this)

        val ListTerremotos : MutableList<Eartquake> = mutableListOf()
        ListTerremotos.add(Eartquake("01","peru",1.5,10,151.5151,5454.54))
        ListTerremotos.add(Eartquake("02","chile",1.5,10,151.5151,5454.54))
        ListTerremotos.add(Eartquake("03","ecuador",1.5,10,151.5151,5454.54))
        ListTerremotos.add(Eartquake("04","brasil",1.5,10,151.5151,5454.54))

        //asignamos el adapter personalizado
        var adapter = EqAdapter()
        recycle.adapter = adapter
        adapter.submitList(ListTerremotos)
    }
}