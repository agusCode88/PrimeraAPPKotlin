/* Este código es una clase en Kotlin que se encarga de definir una actividad de Android, específicamente la actividad principal de una aplicación.
La actividad principal es la pantalla que se muestra cuando se inicia la aplicación.*/

package com.example.eventoboton // Se define el paquete donde se encuentra la clase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.acividadboton.Boton
import com.example.acividadboton.ButtonDesign
import com.example.eventoboton.modelo.Planeta // Se importan las clases y librerías necesarias

class MainActivity :
    AppCompatActivity() { // Se define la clase MainActivity que hereda de la clase AppCompatActivity
    //Método que se ejecuta al crearse la actividad
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Establece el layout de la actividad
        setContentView(R.layout.activity_main)

        //Llama al método vistaApp para configurar la vista de la actividad
        vistaApp()
    }

    //Método para configurar la vista de la actividad
    fun vistaApp() {

        //Obtiene una referencia al botón de la vista mediante su ID
        var boton = findViewById<Button>(R.id.buttonmain)

        //Obtiene una referencia al campo de texto de la vista mediante su ID
        var campoTexto = findViewById<EditText>(R.id.campoNombre)

        //Obtiene el texto ingresado en el campo de texto
        var campoTextoCopia = campoTexto.text

        //Obtiene una referencia al botón de compartir de la vista mediante su ID
        var botonCompartir = findViewById<Button>(R.id.buttonShare)

        //Crea una instancia de la clase Boton con los parámetros "Presioname" y "center"
        var boton2 = Boton("Presioname", "center")

        //Crea una instancia de la clase ButtonDesign con los parámetros "Presioname", "Center" y 40
        var disenio = ButtonDesign("Presioname", "Center", 40)

        //Infla la vista del botón
        disenio.inflar()

        //Infla la vista del botón 2
        boton2.inflar()

        //Configura el listener del botón para que se ejecute cuando se haga clic sobre él
        boton.setOnClickListener {

            //Crea una instancia de la clase Planeta con los parámetros "Mercurio", 0.1f, 77000000, "", "Miércoles"
            var planeta = Planeta("Mercurio", 0.1f, 77000000, "", "Miércoles")

            //Crea una instancia de la clase Intent para pasar datos entre actividades
            var intent = Intent(this, SegundaActividad::class.java)

            //Muestra un mensaje en el logcat con el nombre ingresado en el campo de texto
            Log.i("EventoBoton", "Le has dado click, el nombre es : ${campoTextoCopia}")

            //Muestra un mensaje emergente con el nombre ingresado en el campo de texto
            Toast.makeText(
                this, "Presione el boton y tu nombre es " +
                        ": ${campoTextoCopia}", Toast.LENGTH_LONG
            ).show()

            //Agrega los datos a pasar en el intent
            intent.putExtra("valor", "Hola " + campoTextoCopia)
            intent.putExtra("planeta", planeta)

            //Inicia la segunda actividad y pasa los datos mediante el intent
            startActivity(intent)
        }

        //Configura el listener del botón de compartir para que se ejecute cuando se haga clic sobre él
        botonCompartir.setOnClickListener({

            //Crea una instancia de la clase Intent para compartir contenido
            var intent = Intent()

            //Establece la acción del intent en enviar
            intent.action = Intent.ACTION_SEND

            //Agrega el texto a compartir
            intent.putExtra(Intent.EXTRA_TEXT, "Hola, te saludo desde la Galaxia")

            //Establece el tipo de contenido del intent
            intent.type = "text/plain"

            //Inicia una actividad para compartir el contenido y muestra un diálogo para seleccion
            startActivity(Intent.createChooser(intent, "Selecciona tu APP: "))
        })

    }
}

