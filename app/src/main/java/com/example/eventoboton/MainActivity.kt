/* Este archivo es la clase MainActivity, donde se implementa la funcionalidad de la actividad principal de la aplicación.
Se definen las variables, se importan las librerías y clases necesarias, y se define la función vistaApp() para manejar los eventos de los botones. */

package com.example.eventoboton // Se define el paquete donde se encuentra la clase

import android.content.Intent // Se importa la clase Intent de la librería android.content
import androidx.appcompat.app.AppCompatActivity // Se importa la clase AppCompatActivity de la librería androidx.appcompat.app
import android.os.Bundle // Se importa la clase Bundle de la librería android.os
import android.util.Log // Se importa la clase Log de la librería android.util
import android.widget.Button // Se importa la clase Button de la librería android.widget
import android.widget.EditText // Se importa la clase EditText de la librería android.widget
import android.widget.Toast // Se importa la clase Toast de la librería android.widget
import com.example.acividadboton.Boton // Se importa la clase Boton de la actividad Boton
import com.example.acividadboton.ButtonDesign // Se importa la clase ButtonDesign de la actividad Boton
import com.example.eventoboton.databinding.ActivityMainBinding // Se importa la clase ActivityMainBinding de la actividad MainActivity
import com.example.eventoboton.modelo.Planeta // Se importa la clase Planeta del paquete com.example.eventoboton.modelo

private lateinit var binding: ActivityMainBinding // Se define la variable binding de tipo ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =
            ActivityMainBinding.inflate(layoutInflater) // Se infla el diseño de la actividad MainActivity mediante la variable binding
        setContentView(binding.root) // Se define la vista principal de la actividad
        vistaApp() // Se llama a la función vistaApp() para manejar los eventos de los botones
    }

    fun vistaApp() {

        var boton =
            findViewById<Button>(R.id.buttonmain) // Se define la variable boton para el botón principal de la actividad
        var campoTexto =
            findViewById<EditText>(R.id.campoNombre) // Se define la variable campoTexto para el campo de texto de la actividad
        var campoTextoCopia =
            campoTexto.text // Se copia el contenido del campo de texto en la variable campoTextoCopia
        var botonCompartir =
            findViewById<Button>(R.id.buttonShare) // Se define la variable botonCompartir para el botón compartir de la actividad
        var boton2 = Boton(
            "Presioname",
            "center"
        ) // Se define la variable boton2 como un objeto de la clase Boton, con los valores "Presioname" y "center"
        var disenio = ButtonDesign(
            "Presioname", "Center",
            40
        ) // Se define la variable disenio como un objeto de la clase ButtonDesign, con los valores "Presioname", "Center" y 40
        disenio.inflar() // Se infla el diseño del botón mediante la variable disenio
        boton2.inflar() // Se infla el botón mediante la variable boton2
        // Intent Explicito y paso de Datos entre Activites
        boton.setOnClickListener {

            var planeta = Planeta("Mercurio", 0.7f, 700000000, "", "Miercoles")
            // Intent Explicito
            var intent = Intent(this, SegundaActividad::class.java)

            Log.i("EventoBoton", "Le has dado click, el nombre es : ${campoTextoCopia}")
            Toast.makeText(
                this, "Presione el boton y tu nombre es " +
                        ": ${campoTextoCopia}", Toast.LENGTH_LONG
            ).show()


            intent.putExtra("valor", "Hola " + campoTextoCopia)
            intent.putExtra("planeta", planeta)
            startActivity(intent)
        }

        // Intent implicito
        botonCompartir.setOnClickListener({
            var intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT, "Hola, te saludo desde la Galaxia")
            intent.type = "text/plain"
            startActivity(Intent.createChooser(intent, "Selecciona tu APP:"))
        })

        // Se define una acción a realizar cuando se hace click en el botón de la cámara
        binding.btnCamera.setOnClickListener {
// Se crea un nuevo intent para abrir la actividad de la cámara
            val intentCamera = Intent(this, TerceraActividad::class.java)
// Se inicia la actividad de la cámara
            startActivity(intentCamera)
        }

    }
}

