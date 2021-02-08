package com.example.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.navigation.findNavController
import com.example.fragment.Fragments.DetailsFragment
import com.example.fragment.Fragments.LisFragment
import com.example.fragment.Modelo.Pokemon

class MainActivity : AppCompatActivity() ,LisFragment.ListFragmentInterface{

    private lateinit var detailsFragment: DetailsFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




    }
    //LE MANDO EL ITEM SELECCIONADO DESDE EL CONTROLADOR FRAGMENT
    override fun onItemSelected(item: Pokemon) {
        //llamamos a la "ruta que seguiremos para llegar a la siguiente pantalla"
        findNavController(R.id.main_navigation_Container).navigate(LisFragmentDirections.actionLisFragmentToPokemonDetailFragment())
    }
    //SEGUNDA FORMA DE RECUPERAR DATOS
    fun ObteniendoDatosDesdeFragment(item : Pokemon){
        Toast.makeText(this, "${item.nombre} seleecionado activity padre", Toast.LENGTH_SHORT).show()
    }
}