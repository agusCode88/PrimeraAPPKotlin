package com.example.eventoboton

import android.Manifest.permission.CAMERA
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.eventoboton.databinding.ActivityTerceraActividadBinding


private lateinit var binding: ActivityTerceraActividadBinding
var requestPersmissionCode = 2
var requestPersmissionCamera = 3

class TerceraActividad : ActionBarActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTerceraActividadBinding.inflate(layoutInflater)
        setContentView(binding.root)

        _toolbar = findViewById<Toolbar>(R.id.toolbar_id)
        loadActionBarInActivity(_toolbar as Toolbar)
        loadButtonBackInScreen(true)
        loadItemsOnMenuActionBar(_toolbar as Toolbar)

        binding.btnTakePicture.setOnClickListener { takeAPicture() }


    }


    /*
    Permisos en tiempo de ejecucion , a aprtir de android 6.0 Api 23 EN ADELANTE
    Son llamadas asincronas , no tenemos seguridad de cuando el usuario me respondera
    hay que saber cuando lo hace.

     */

    //Anadir permisos al Manifest
    // Comprobar el permiso de la camara
    private fun takeAPicture() {

        if (ContextCompat.checkSelfPermission(this, CAMERA) != PackageManager.PERMISSION_GRANTED) {
            // Si el permiso no fue concedido, solicítalo
            ActivityCompat.requestPermissions(this, arrayOf(CAMERA), requestPersmissionCode)

            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(intent, requestPersmissionCamera)


        } else {
            // Hya que llamar a la camara
            //Permsiso aceptado por android
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(intent, requestPersmissionCamera)
        }


    }

    /*
      Metodo que escucha la respuesta del usuario en el cuadro de Dialogo
     Todos los permisios que se soliciten van a llegar a este metodo , hayq que devolver un codigo
     */


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        when (requestCode) {

            requestPersmissionCamera -> {

                if (grantResults.size == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    //Permsiso aceptado por android
                    val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                    startActivityForResult(intent, requestPersmissionCamera)
                } else {
                    // Es porque no acepto el permiso
                    Toast.makeText(
                        this,
                        "No tiene permisos para tomar fotos en esta APP ",
                        Toast.LENGTH_LONG
                    ).show()

                }

            }

        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK && requestCode == requestPersmissionCamera && data != null) {
            val imageBitMap = data.extras?.get("data") as Bitmap
            if (imageBitMap != null) {
                binding.picture.setImageBitmap(imageBitMap)
            } else {
                Toast.makeText(this, "No se pudo tomar la foto", Toast.LENGTH_LONG).show()
            }
        }

    }


}



