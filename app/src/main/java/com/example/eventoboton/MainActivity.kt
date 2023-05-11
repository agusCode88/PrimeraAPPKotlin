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
import com.example.eventoboton.databinding.ActivityMainBinding
import com.example.eventoboton.modelo.Planeta // Se importan las clases y librerías necesarias

private lateinit var binding: ActivityMainBinding

class MainActivity :
    AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        vistaApp()
    }

    fun vistaApp() {

        var boton = findViewById<Button>(R.id.buttonmain)
        var campoTexto = findViewById<EditText>(R.id.campoNombre)
        var campoTextoCopia = campoTexto.text
        var botonCompartir = findViewById<Button>(R.id.buttonShare)
        var boton2 = Boton("Presioname", "center")
        var disenio = ButtonDesign("Presioname", "Center", 40)
        disenio.inflar()
        boton2.inflar()
        boton.setOnClickListener {


            var planeta = Planeta("Mercurio", 0.1f, 77000000, "", "Miércoles")
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


        botonCompartir.setOnClickListener({
            var intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT, "Hola, te saludo desde la Galaxia")
            intent.type = "text/plain"
            startActivity(Intent.createChooser(intent, "Selecciona tu APP: "))
        })
        binding.btnCamera.setOnClickListener {
            val intentCamera = Intent(this, TerceraActividad::class.java)
            startActivity(intentCamera)

        }
    }
}

