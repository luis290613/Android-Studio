package com.example.recyclerview.adaptador

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.Modelo.Eartquake
import androidx.recyclerview.widget.ListAdapter
import com.example.recyclerview.R


class EqAdapter: ListAdapter<Eartquake,EqAdapter.eqViewHolder>(DiffCallback){
    //copiar y pegar en todos los adapter
    companion object DiffCallback : DiffUtil.ItemCallback<Eartquake>(){

        override fun areItemsTheSame(oldItem: Eartquake, newItem: Eartquake): Boolean {
            return oldItem.id == newItem.id
        }
        override fun areContentsTheSame(oldItem: Eartquake, newItem: Eartquake): Boolean {
            return  oldItem == newItem
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EqAdapter.eqViewHolder {
        //insertamos el adapter
        var view : View = LayoutInflater.from(parent.context).inflate(R.layout.item_adapter,parent,false)
        return eqViewHolder(view)
    }

    override fun onBindViewHolder(holder: EqAdapter.eqViewHolder, position: Int) {
        //obtengo el objeto segun la posicion
        val item = getItem(position)
        holder.magnitud.text = item.magnitud.toString()
        holder.titulo.text = item.place
    }
    //clase que pertenece al adapter : clase interna
    inner class eqViewHolder(val view: View) : RecyclerView.ViewHolder(view){
        //vista-controlador
        val magnitud = view.findViewById<TextView>(R.id.magnitud)
        val titulo = view.findViewById<TextView>(R.id.titulo)

    }
}