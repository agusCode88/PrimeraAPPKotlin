package com.example.acividadboton

import com.example.eventoboton.abstracta.View
import com.example.eventoboton.interfaces.ButtonListeners

// Declaración de la clase Boton, que hereda de la clase View e implementa la interfaz ButtonListeners
open class Boton(
// Declaración de las propiedades de la clase Boton
    open var texto: String, open var posicion: String
) : View(), ButtonListeners {
    // Implementación del método inflar de la clase View
    override fun inflar() {
        println("Inflando el boton en el View")
    }

    // Implementación del método onclick de la interfaz ButtonListeners
    override fun onclick() {
        println("Se ha hecho clic en el botón $texto")
        cambiarFondoBoton()

    }

    // Función que cambia el fondo del botón
    fun cambiarFondoBoton() {
        println("Se ha cambiado el fondo del boton $texto")
    }


}