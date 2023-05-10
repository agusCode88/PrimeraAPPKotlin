package com.example.eventoboton

import android.content.Intent
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
        var boton = findViewById<Button>(R.id.buttonmain)
        var campoTexto = findViewById<EditText>(R.id.campoNombre)
        var campoTextoCopia = campoTexto.text


        var boton2 = Boton("Presioname","center")
        var disenio = ButtonDesign("Presioname","Center",40)

        disenio.inflar()
        boton2.inflar()

        boton.setOnClickListener {
            //Intent Explicito
            var intent = Intent(this, SegundaActividad::class.java)
            Log.i("EventoBoton","Le has dado click, el nombre es : ${campoTextoCopia}")
            Toast.makeText(this,"Presione el boton y tu nombre es " +
                    ": ${campoTextoCopia}",Toast.LENGTH_LONG).show()

            intent.putExtra("valor", "Hola " + campoTextoCopia)
            startActivity(intent)

//            boton2.onclick()
//            boton.setBackgroundColor(ContextCompat.getColor(this, com.google.android.material.R.color.abc_decor_view_status_guard))

        }

    }
}

