package com.example.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.fragment.Fragments.DetailsFragment
import com.example.fragment.Fragments.LisFragment
import com.example.fragment.Modelo.Pokemon

class MainActivity : AppCompatActivity() ,LisFragment.ListFragmentInterface{

    private lateinit var detailsFragment: DetailsFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //asignamos el fragment -> ya podemos acceder a sus metodos para enviarle lo que queramos
        detailsFragment = supportFragmentManager.findFragmentById(R.id.detail_fragment) as DetailsFragment

    }
    //LE MANDO EL ITEM SELECCIONADO DESDE EL CONTROLADOR FRAGMENT
    override fun onItemSelected(item: Pokemon) {
        //Toast.makeText(this, "${item.nombre} seleecionado activity padre", Toast.LENGTH_SHORT).show()
        detailsFragment.setPokemonDate(item)
    }
    //SEGUNDA FORMA DE RECUPERAR DATOS
    fun ObteniendoDatosDesdeFragment(item : Pokemon){
        Toast.makeText(this, "${item.nombre} seleecionado activity padre", Toast.LENGTH_SHORT).show()
    }
}