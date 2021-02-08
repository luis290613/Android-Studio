package com.example.fragment.Fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fragment.MainActivity
import com.example.fragment.Modelo.Pokemon
import com.example.fragment.R
import com.example.fragment.adaptador.adapList
import java.lang.ClassCastException


class LisFragment : Fragment() {

    //CREAMOS INTERFACE PARA ENVIAR LOS DATOS AL ACTIVITY PADRE
    interface  ListFragmentInterface{
        fun onItemSelected(item: Pokemon)
    }
    //CREAMOS VARIABLE TIPO ListFragmentInterface
    private  lateinit var itemSelectInterface : ListFragmentInterface

    //FUNCION QUE SE IMPLEMENTA PRIMERO CUANDO SE CREA EL FRAGMENT
    override fun onAttach(context: Context) {
        super.onAttach(context)
        //OBLIGAMOS QUE EL ACTIVITY QUE UTILICE EL FRAGMENT IMPLEMENTE SI O SI LA INTERFACE
        itemSelectInterface = try {
            context as ListFragmentInterface
        }catch (e: ClassCastException){
            throw ClassCastException("$context debe implementar si o si la interface")
        }
    }




    //en los fragmen el onCreateView es igual al onCreate del Main (activity)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_lis, container, false)

        //v-c
        var recyclerView : RecyclerView =  view.findViewById(R.id.fragmentList)

        //delegado  -> requireActivity lo utilizamos para obtener el contexto desde el activity padre
        recyclerView.layoutManager = LinearLayoutManager(requireActivity())
        val ListaPokemon : MutableList<Pokemon> = mutableListOf()
        ListaPokemon.add(Pokemon(10,"prueba 01",Pokemon.TypePokemon.agua,"https://www.ecestaticos.com/image/clipping/557/418/e1edadba8d25985e80db6140aab64e7c/apple-empieza-manana-la-primera-wwdc-completamente-digital-de-su-historia.jpg"))
        ListaPokemon.add(Pokemon(20,"prueba 02",Pokemon.TypePokemon.fuego,"https://www.ecestaticos.com/image/clipping/557/418/e1edadba8d25985e80db6140aab64e7c/apple-empieza-manana-la-primera-wwdc-completamente-digital-de-su-historia.jpg"))
        ListaPokemon.add(Pokemon(30,"prueba 03",Pokemon.TypePokemon.tierra,"https://www.ecestaddddticos.com/image/clipping/557/418/e1edadba8d25985e80db6140aab64e7c/apple-empieza-manana-la-primera-wwdc-completamente-digital-de-su-historia.jpg"))
        ListaPokemon.add(Pokemon(40,"prueba 04",Pokemon.TypePokemon.aire,"corrumpido para prueba"))

        //asignamos el adapter personalizado
        var adapter = adapList()
        recyclerView.adapter = adapter
        adapter.submitList(ListaPokemon)

        adapter.onItemClickListener = {
            //Toast.makeText(requireActivity(),it.nombre,Toast.LENGTH_LONG).show()

            //ENVIAMOS ITEM SELECCIONADO -> PRIMERA FORMA
            itemSelectInterface.onItemSelected(it)

            //"" -> SEGUNDA FORMA
            //(activity as MainActivity).ObteniendoDatosDesdeFragment(it)
        }

        return view
    }


}