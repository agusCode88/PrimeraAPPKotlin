package com.example.eventoboton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.acividadboton.Boton
import com.example.acividadboton.ButtonDesign

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        vistaApp()
    }

    fun vistaApp(){

        var boton = findViewById<Button>(R.id.boton_main)
        var campoTexto = findViewById<EditText>(R.id.campoNombre)
        var campoTextoCopia = campoTexto.text

        var boton2 = Boton("Presioname","center")
        var disenio = ButtonDesign("Presioname","Center",40)

        disenio.inflar()
        boton2.inflar()

        boton.setOnClickListener {

            Log.i("EventoBoton","Le has dado click, el nombre es : ${campoTextoCopia}")
            Toast.makeText(this,"Pesione el boton y tu nombre es " +
                    ": ${campoTextoCopia}",Toast.LENGTH_LONG).show()
            boton2.onclick()
            boton.setBackgroundColor(ContextCompat.getColor(this, com.google.android.material.R.color.abc_decor_view_status_guard))

        }

    }
}

