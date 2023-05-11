package com.example.eventoboton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.eventoboton.modelo.Planeta

class SegundaActividad : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segunda_actividad)

        var textoResulado = findViewById<TextView>(R.id.txtResult)
        var nombrePlaneta = findViewById<TextView>(R.id.txtNombrePlaneta)
        val rescatado:String? = intent.getStringExtra("valor").orEmpty()
        val planetaRescatado = intent.getParcelableExtra<Planeta>("planeta")

        if(rescatado != null && planetaRescatado != null){
            textoResulado.text = rescatado
            nombrePlaneta.text = planetaRescatado.nombre
        }else{
            textoResulado.text = "No se ha encontrado nada"
        }

    }
}