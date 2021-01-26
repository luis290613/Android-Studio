package com.example.appclima

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class Ciudad : AppCompatActivity() {

    val KeyCiudad = "KeyC"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ciudad)

        configurationButtons()
    }

    fun configurationButtons(){
        val bMexico = findViewById<Button>(R.id.btnMexico)
        val bMerlin = findViewById<Button>(R.id.btnMerlin)

        bMexico.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra(KeyCiudad, "ciudad de méxico")
            startActivity(intent)
        })

        bMerlin.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra(KeyCiudad,"ciudad de merlín")
            startActivity(intent)
        })
    }
}