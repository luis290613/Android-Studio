package com.example.fragment.Fragments

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.fragment.Modelo.Pokemon
import com.example.fragment.R
import org.w3c.dom.Text


class DetailsFragment : Fragment() {
    lateinit var nombre : TextView
    lateinit var codigo : TextView
    lateinit var foto : ImageView
    lateinit var progress : ProgressBar

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var viewRoot = inflater.inflate(R.layout.fragment_details, container, false)

        codigo = viewRoot.findViewById(R.id.texto1)
        nombre = viewRoot.findViewById(R.id.texto2)
        foto = viewRoot.findViewById(R.id.imgImagenn)
        progress = viewRoot.findViewById(R.id.loading_wheel)
        return viewRoot
    }

    fun setPokemonDate(item: Pokemon){

        progress.visibility = View.VISIBLE
        codigo.text = getString(R.string.texto_id,item.id)
        nombre.text = getString(R.string.texto_nombre,item.nombre)
        //listener -> agregando una validacion de errores
        //Importante: esta es una forma de implementar una interfaz
        Glide.with(this).load(item.imgUrl).listener(object :RequestListener<Drawable>{

            override fun onLoadFailed(
                e: GlideException?,
                model: Any?,
                target: Target<Drawable>?,
                isFirstResource: Boolean
            ): Boolean {
                progress.visibility = View.GONE
                foto.setImageResource(R.drawable.ic_launcher_background)
                return false
            }

            override fun onResourceReady(
                resource: Drawable?,
                model: Any?,
                target: Target<Drawable>?,
                dataSource: DataSource?,
                isFirstResource: Boolean
            ): Boolean {
                progress.visibility = View.GONE
                return false
            }

        }).error(R.drawable.icons8_naranja).into(foto);
    }

}