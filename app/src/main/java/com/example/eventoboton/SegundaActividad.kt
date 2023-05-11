package com.example.eventoboton

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.eventoboton.modelo.Planeta

class SegundaActividad : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_actividad2)

        var textoResultado = findViewById<TextView>(R.id.txtResult)
        var nombrePlaneta = findViewById<TextView>(R.id.txtNombrePlaneta)
        val rescatado: String? = intent.getStringExtra("valor").orEmpty()
        val planetaRescatado = intent.getParcelableExtra<Planeta>("planeta")

        if (rescatado != null && planetaRescatado != null) {
            textoResultado.text = rescatado
            nombrePlaneta.text  = planetaRescatado.nombre

        } else {
            textoResultado.text = "No llego"

        }

    }
}