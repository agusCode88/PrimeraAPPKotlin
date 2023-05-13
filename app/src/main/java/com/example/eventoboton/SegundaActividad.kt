package com.example.eventoboton

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.example.eventoboton.modelo.Planeta

class SegundaActividad : ActionBarActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_actividad2)

        _toolbar = findViewById<Toolbar>(R.id.toolbar_id)
        loadActionBarInActivity(_toolbar)
        loadButtonBackInScreen(true)
        loadItemsOnMenuActionBar(_toolbar )

        var textoResultado = findViewById<TextView>(R.id.txtResult)
        var nombrePlaneta = findViewById<TextView>(R.id.txtNombrePlaneta)
        val rescatado: String? = intent.getStringExtra("valor").orEmpty()
        val planetaRescatado = intent.getParcelableExtra<Planeta>("planeta")

        if (rescatado != null && planetaRescatado != null) {
            textoResultado.text = rescatado
            nombrePlaneta.text  = planetaRescatado.nombre

        } else {
            textoResultado.text = "No llego aca"

        }

    }


}