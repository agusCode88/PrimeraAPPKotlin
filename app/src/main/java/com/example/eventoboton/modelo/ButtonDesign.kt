/* Este es un archivo de Kotlin que define una clase llamada ButtonDesign que hereda de otra clase llamada Boton. Esta clase tiene tres propiedades: texto, posicion y esquinas, donde texto y posicion son heredadas de Boton y esquinas es específica de la clase ButtonDesign. */

package com.example.acividadboton

//La clase ButtonDesign hereda de la clase Boton.
class ButtonDesign(
// La propiedad "texto" es una cadena que contiene el texto que aparece en el botón. /
    override var texto: String,
// La propiedad "posicion" es una cadena que indica la posición del botón. /
    override var posicion: String,
// La propiedad "esquinas" es un entero que indica el tamaño de las esquinas del botón. */
    var esquinas: Int
) : Boton(texto, posicion) {
    /* La función "inflar" se encarga de darle bordes al botón. */
    override fun inflar() {
        /* Se imprime un mensaje que indica el texto, la posición y el tamaño de las esquinas del botón. */
        println("Le estoy dando bordes al botón $texto con la posición $posicion y con este tamaño de esquinas $esquinas")
        /* Se llama a la función "inflar" de la clase padre (Boton) para que se ejecute su funcionalidad. */
        super.inflar()
    }

}