package com.example.menuwip.adaptador

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import com.example.menuwip.R
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.menuwip.model.Producto

class Adaptador : ListAdapter<Producto,Adaptador.pViewHolder>(DiffCallback){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adaptador.pViewHolder {

        var view : View = LayoutInflater.from(parent.context).inflate(R.layout.item_wip,parent,false)
        return pViewHolder(view)

    }

    override fun onBindViewHolder(holder: Adaptador.pViewHolder, position: Int) {
        val item = getItem(position)
        holder.textoImagen.text = item.titulo
        holder.puntuacion.text = item.puntuacion.toString()
        holder.tiempo.text = item.tiempo
        holder.precio.text = item.precio.toString()
        holder.categoria.text = item.categoria

        if (item.favorito){
            holder.textoImagen.visibility = View.VISIBLE
        }else{
            holder.textoImagen.visibility = View.GONE

        }

        holder.textoImagen.setOnClickListener {
            fnHacerAccion(it.context,item)
        }

    }

    inner class pViewHolder(val view: View) : RecyclerView.ViewHolder(view){
        val textoImagen = view.findViewById<TextView>(R.id.textoDentroImage)
        val puntuacion = view.findViewById<TextView>(R.id.texto1)
        val tiempo = view.findViewById<TextView>(R.id.texto2)
        val precio = view.findViewById<TextView>(R.id.texto3)
        val categoria = view.findViewById<TextView>(R.id.categoria)


    }
    //podemos validar por id y lo que quedramos hacer con cada item
    fun fnHacerAccion(context : Context, item : Producto ){
        Toast.makeText(context,item.titulo,Toast.LENGTH_SHORT).show()
    }


    //copiar y pegar en todos los adapter
    companion object DiffCallback : DiffUtil.ItemCallback<Producto>(){

        override fun areItemsTheSame(oldItem: Producto, newItem:Producto): Boolean {
            return oldItem.id == newItem.id
        }
        override fun areContentsTheSame(oldItem: Producto, newItem: Producto): Boolean {
            return  oldItem == newItem
        }


    }


}