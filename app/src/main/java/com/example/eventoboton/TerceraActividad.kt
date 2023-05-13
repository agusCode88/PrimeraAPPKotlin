/* Este es un código en Kotlin que contiene una clase llamada TerceraActividad, la cual extiende de AppCompatActivity. Esta clase tiene tres funciones que se explicarán a continuación. */

// Importaciones necesarias para utilizar las funcionalidades del sistema operativo y las dependencias externas
package com.example.eventoboton
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.eventoboton.databinding.ActivityMainBinding
import com.example.eventoboton.databinding.ActivityTerceraActividadBinding

// Declaraciones de variables y objetos globales
private lateinit var binding: ActivityTerceraActividadBinding
var requestPermissionCode = 2
var requestPermissionCamera = 3

// Clase principal que representa una actividad
class TerceraActividad : AppCompatActivity() {
    // Función que se ejecuta al crear la actividad
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTerceraActividadBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var toolbar = findViewById<Toolbar>(R.id.toolbar_id)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Asignación de un listener al botón "btntakepicture" que llama a la función takeAPicture()
        binding.btntakepicture.setOnClickListener { takeAPicture() }

    }

    // Función que se ejecuta cuando se presiona el botón "btntakepicture"
    private fun takeAPicture() {
        // Verifica si la aplicación tiene permiso para utilizar la cámara
        if (ContextCompat.checkSelfPermission(
                this,
                android.Manifest.permission.CAMERA
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // Si no tiene permiso, solicita el permiso al usuario
            ActivityCompat.requestPermissions(
                this,
                arrayOf(android.Manifest.permission.CAMERA),
                requestPermissionCode
            )
        } else {
            // Si ya tiene permiso, abre la cámara para tomar una foto
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(intent, requestPermissionCamera)
        }
    }

    // Función que se ejecuta cuando el usuario responde a la solicitud de permiso
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        // Verifica si la solicitud de permiso fue para la cámara
        when (requestCode) {
            requestPermissionCode -> {
                // Si el usuario concedió el permiso, abre la cámara para tomar una foto
                if (grantResults.size == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                    startActivityForResult(intent, requestPermissionCamera)
                } else {
                    // Si el usuario negó el permiso, muestra un mensaje de error
                    Toast.makeText(this, "Permiso denegado", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    // Función que se ejecuta cuando se termina de tomar una foto
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Verifica si la acción que se realizó fue tomar una foto
        if (requestCode == requestPermissionCamera && resultCode == RESULT_OK && data != null) {
            // Si se tomó una foto correctamente, obtiene la imagen en formato Bitmap y la muestra en el ImageView "picture"
            val imageBitmap = data.extras!!.get("data") as Bitmap

            binding.picture.setImageBitmap(imageBitmap)
        } else {
            Toast.makeText(this, "Error al tomar foto", Toast.LENGTH_SHORT).show()
        }
    }
}

