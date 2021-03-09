package com.example.fragment.adaptador

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.fragment.Modelo.Pokemon
import com.example.fragment.R
import com.example.fragment.R.color.black

class adapList: ListAdapter<Pokemon, adapList.eqViewHolder>(DiffCallback){
    //copiar y pegar en todos los adapter
    companion object DiffCallback : DiffUtil.ItemCallback<Pokemon>(){

        override fun areItemsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
            return oldItem.id == newItem.id
        }
        override fun areContentsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
            return  oldItem == newItem
        }
    }


    // similitud de closure en SWIFT
    lateinit var onItemClickListener : (Pokemon) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): eqViewHolder {
        //insertamos el adapter
        var view : View = LayoutInflater.from(parent.context).inflate(R.layout.activity_adapter_list,parent,false)
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
        val id = view.findViewById<TextView>(R.id.txtCodigo)
        val nombre = view.findViewById<TextView>(R.id.txtNombre)
        val tipo = view.findViewById<ImageView>(R.id.imgImagen)

        fun bind(item : Pokemon){
            id.text = item.id.toString()
            nombre.text = item.nombre
            //condicional para tipo de imagen
            when (item.tipo){
                Pokemon.TypePokemon.agua -> tipo.setImageResource(R.drawable.icons8_blanco)
                Pokemon.TypePokemon.fuego -> tipo.setImageResource(R.drawable.icons8_blanco)
                Pokemon.TypePokemon.tierra -> tipo.setImageResource(R.drawable.icons8_naranja)
                Pokemon.TypePokemon.aire -> tipo.setImageResource(R.drawable.icons8_naranja)
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