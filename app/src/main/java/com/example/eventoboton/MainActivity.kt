package com.example.eventoboton

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
import com.example.eventoboton.modelo.Planeta

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        vistaApp()
    }

    fun vistaApp(){

        var boton = findViewById<Button>(R.id.boton_main)
        var campoTexto = findViewById<EditText>(R.id.campoNombre)
        var campoTextoCopia = campoTexto.text
        var botonCompartir = findViewById<Button>(R.id.botonShare)

        var boton2 = Boton("Presioname","center")
        var disenio = ButtonDesign("Presioname","Center",40)

        disenio.inflar()
        boton2.inflar()

        // Intent Explicito y paso de Datos entre Activites
        boton.setOnClickListener {

            var planeta = Planeta("Mercurio",0.7f,0.39f,"","Miercoles")
            // Intent Explicito
            var intent = Intent(this,SegundaActividad::class.java)

            Log.i("EventoBoton","Le has dado click, el nombre es : ${campoTextoCopia}")
            Toast.makeText(this,"Pesione el boton y tu nombre es " +
                    ": ${campoTextoCopia}",Toast.LENGTH_LONG).show()

            intent.putExtra("valor","Hola "+ campoTextoCopia)
            intent.putExtra("planeta",planeta)
            startActivity(intent)

           // boton2.onclick()
            //boton.setBackgroundColor(ContextCompat.getColor(this, com.google.android.material.R.color.abc_decor_view_status_guard))
        }
        // Intent implicito
        botonCompartir.setOnClickListener({
            var intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT,"Hola te saludo desde la Galaxia")
            intent.type = "text/plain"
            startActivity(Intent.createChooser(intent,"Selecciona tu APP:"))
        })

        binding.btnActivityCamera.setOnClickListener {
            // Vamos a llamar a otra actividad
            val intentCamera = Intent(this,TerceraActividad::class.java)
            startActivity(intentCamera)

        }

    }
}

