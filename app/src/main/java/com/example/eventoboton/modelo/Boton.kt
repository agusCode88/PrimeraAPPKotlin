package com.example.acividadboton

import com.example.eventoboton.abstracta.View
import com.example.eventoboton.interfaces.ButtonListeners

open class Boton(open var texto:String,
                 open var posicion:String): View(),ButtonListeners {

    override fun inflar() {
        println("Inflando el boton en el View")
    }

    override fun onclick() {
        println("Se ha hecho clic en el botón $texto")
        cambiarFondoBoton()

    }

    fun cambiarFondoBoton(){
        println("Se ha cambiado el fondo del boton $texto")
    }

}