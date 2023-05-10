package com.example.eventoboton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SegundaActividad : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segunda_actividad)

        var textoResulado = findViewById<TextView>(R.id.txtResult)
        val rescatado:String? = intent.getStringExtra("valor").orEmpty()
        if(rescatado != null) {
            textoResulado.text = rescatado
        }else{
            textoResulado.text = "No se ha encontrado nada"
        }

    }
}