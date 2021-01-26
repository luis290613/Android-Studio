package com.example.recursosejemplo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //relacionando vista-controlador
        val bSaludar = findViewById<Button>(R.id.btnSaludar)
        val textoNombre = findViewById<EditText>(R.id.edNombre)
        val cbDev = findViewById<CheckBox>(R.id.cbDeveloper)

        //agregando accion al boton
        bSaludar.setOnClickListener(View.OnClickListener {

            if(validarDatos()){
                //mensaje
                if (cbDev.isChecked){
                    Toast.makeText(this,"Bienvenido :" + textoNombre.text + " usted es un developer", Toast.LENGTH_LONG).show()
                }else{
                    Toast.makeText(this,"Bienvenido :" + textoNombre.text , Toast.LENGTH_LONG).show()
                }

            }else{
                //mensaje
                Toast.makeText(this,"ingrese su nombre soldado", Toast.LENGTH_SHORT).show()
            }
        })
    }

    fun validarDatos():Boolean{

        val nombre = findViewById<EditText>(R.id.edNombre)
        val nombreUsuario = nombre.text
        if (nombreUsuario.isNullOrEmpty()){
            return false
        }
        return true
    }






}