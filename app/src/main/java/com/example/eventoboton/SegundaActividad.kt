/*

Este código corresponde a la clase SegundaActividad, que se utiliza para mostrar información recibida desde la actividad principal.
Se importan las librerías necesarias para trabajar con la actividad, como la librería de AppCompatActivity y TextView.
También se importa la clase Planeta desde el paquete modelo.
*/
package com.example.eventoboton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.eventoboton.modelo.Planeta

class SegundaActividad : AppCompatActivity() {
    // En el método onCreate se inicializa la actividad.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Se establece el layout de la actividad.
        setContentView(R.layout.activity_segunda_actividad)

        // Se crean variables para almacenar los TextView del layout.
        var textoResultado = findViewById<TextView>(R.id.txtResult)
        var nombrePlaneta = findViewById<TextView>(R.id.txtNombrePlaneta)

        // Se recupera el valor enviado desde la actividad principal a través de la clave "valor".
        val rescatado: String? = intent.getStringExtra("valor").orEmpty()
        // Se recupera el objeto Planeta enviado desde la actividad principal.
        val planetaRescatado = intent.getParcelableExtra<Planeta>("planeta")

        // Si ambos valores no son nulos, se establece el texto del TextView de resultado con el valor recuperado y se establece el nombre del planeta en el TextView correspondiente.
        if (rescatado != null && planetaRescatado != null) {
            textoResultado.text = rescatado
            nombrePlaneta.text = planetaRescatado.nombre
        } else {
            // En caso contrario, se establece el texto de resultado con un mensaje de error.
            textoResultado.text = "No se ha encontrado nada"
        }

    }


}
/*En resumen, este código define una actividad que muestra información recibida desde la actividad
principal, y se utiliza la clase Planeta del paquete modelo para recuperar un objeto Planeta enviado
desde la actividad principal. También se recuperan valores enviados a través de la clave "valor".
El código verifica que ambos valores no sean nulos y establece el texto correspondiente en los TextView d
el layout de la actividad. Si alguno de los valores es nulo, se muestra un mensaje de error.*/
