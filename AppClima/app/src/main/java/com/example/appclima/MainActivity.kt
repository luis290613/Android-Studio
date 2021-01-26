package com.example.appclima

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var tvCiudad: TextView? = null
    var tvGrados: TextView? = null
    var tvEstatus: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvCiudad = findViewById(R.id.txtCiudad)
        tvGrados = findViewById(R.id.txtGrados)
        tvEstatus = findViewById(R.id.txtEstado)



        val ValorCiudad = intent.getStringExtra("KeyC")

        //println(" valor recibido en intent : $ValorCiudad")
        //Toast.makeText(this,ValorCiudad, Toast.LENGTH_SHORT).show()

        val ciudadMexico = Ciu("ciudad de mexico", 15, "soleado")
        val ciudadBerlin= Ciu("ciudad de berlin", 30, "cielo despejado")

        if (ValorCiudad == "ciudad de méxico"){
            //mostrar informacion de mexico
            tvCiudad?.text = ciudadMexico.nombre
            tvGrados?.text = ciudadMexico.grados.toString() + "°"
            tvEstatus?.text = ciudadMexico.estatus


        }else{
            //si no info de berlin
            tvCiudad?.text = ciudadBerlin.nombre
            tvGrados?.text = ciudadBerlin.grados.toString() + "°"
            tvEstatus?.text = ciudadBerlin.estatus

        }

    }
}