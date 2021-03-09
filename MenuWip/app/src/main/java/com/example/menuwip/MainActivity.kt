package com.example.menuwip

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.menuwip.adaptador.Adaptador
import com.example.menuwip.databinding.ActivityMainBinding
import com.example.menuwip.model.Producto

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fnConfigRecyclerView(binding.idrecyclerview,binding.textoMensaje)
    }
    fun fnConfigRecyclerView(recycleview : RecyclerView,mensaje : TextView){
        //delegamos
        recycleview.layoutManager = LinearLayoutManager(this)

        //lista de productos
        var listaProductos : MutableList<Producto> = mutableListOf()
        listaProductos.add(Producto(10,"prueba1",5.0,"40-50 min",10.00,"lacteos",true))
        listaProductos.add(Producto(20,"prueba2 prueba2 prueba2 prueba2 ",5.0,"40-50 minutos",10.00,"lacteos",true))
        listaProductos.add(Producto(30,"prueba3",5.0,"40-50 min",10.00,"lacteos",true))
        listaProductos.add(Producto(40,"prueba4",5.0,"40-50 min",10.00,"lacteos",false))
        listaProductos.add(Producto(50,"prueba5",5.0,"40-50 min",10.00,"lacteos",true))
        listaProductos.add(Producto(60,"prueba6 prueba2 prueba2",5.0,"40-50 min",10.00,"lacteos",false))

        var adapter = Adaptador()
        recycleview.adapter = adapter
        adapter.submitList(listaProductos)

        if (listaProductos.isEmpty()){
            mensaje.visibility = View.VISIBLE
            recycleview.visibility = View.GONE
        }else{
            mensaje.visibility = View.GONE
            recycleview.visibility = View.VISIBLE
        }
    }
}