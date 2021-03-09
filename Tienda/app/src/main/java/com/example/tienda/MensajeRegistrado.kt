package com.example.tienda

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MensajeRegistrado : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mensaje_registrado)

        //ocultando barra del top que contiene el titulo
        try {
            this.supportActionBar!!.hide()
        } catch (e: NullPointerException) {
        }
        //ocultando botones de la parte inferior
        window.decorView.apply {
            // Hide both the navigation bar and the status bar.
            // SYSTEM_UI_FLAG_FULLSCREEN is only available on Android 4.1 and higher, but as
            // a general rule, you should design your app to hide the status bar whenever you
            // hide the navigation bar.
            systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN
        }
    }
}