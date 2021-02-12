package com.example.crudsqlite.adaptadores

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.crudsqlite.R
import com.example.crudsqlite.modelo.Personaje

class adaptadorRecycler: ListAdapter<Personaje, adaptadorRecycler.eqViewHolder>(DiffCallback){
    //copiar y pegar en todos los adapter
    companion object DiffCallback : DiffUtil.ItemCallback<Personaje>(){

        override fun areItemsTheSame(oldItem: Personaje, newItem: Personaje): Boolean {
            return oldItem.id == newItem.id
        }
        override fun areContentsTheSame(oldItem: Personaje, newItem: Personaje): Boolean {
            return  oldItem == newItem
        }
    }


    // similitud de closure en SWIFT
    lateinit var onItemClickListener : (Personaje) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): eqViewHolder {
        //insertamos el adapter
        var view : View = LayoutInflater.from(parent.context).inflate(R.layout.adapterlist,parent,false)
        return eqViewHolder(view)
    }

    override fun onBindViewHolder(holder: eqViewHolder, position: Int) {

        //obtengo el objeto segun la posicion
        val item = getItem(position)
        //asignamos el bloque de codigo
        holder.bind(item)

    }
    //clase que pertenece al adapter : clase interna
    inner class eqViewHolder(val view: View) : RecyclerView.ViewHolder(view){
        //vista-controlador
    //    val imagen = view.findViewById<ImageView>(R.id.imgPrincipal)
        val nombre = view.findViewById<TextView>(R.id.txtTitulo)
        val descripcion = view.findViewById<TextView>(R.id.txtDescripcion)

        fun bind(item : Personaje){
            nombre.text = item.nombre
            descripcion.text = item.apellido

            //condicional para tipo de imagen
            when (item.sexo){
                //Personaje.TypeSexo.hombre -> imagen.setImageResource(R.drawable.icons8_blanco)
                //Personaje.TypeSexo.mujer -> imagen.setImageResource(R.drawable.icons8_blanco)
                //Personaje.TypeSexo.cabrilla -> imagen.setImageResource(R.drawable.icons8_naranja)
            }
            //1.0 le estamos asignando el bloque de codigo con el item seleccionado
            //2.0 la implmentacion del bloque se da en su controlador desde donde se asigna el adapter
            view.setOnClickListener{
                if (::onItemClickListener.isInitialized)
                    onItemClickListener(item)
            }

        }
    }
}