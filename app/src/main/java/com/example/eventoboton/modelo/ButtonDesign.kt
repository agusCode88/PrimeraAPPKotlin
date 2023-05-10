package com.example.acividadboton

class ButtonDesign(
    override var texto:String,
    override var posicion:String,
    var esquinas:Int) : Boton(texto, posicion) {

    override fun  inflar() {
        println("Le estoy dando bordes al botón $texto con la posición $posicion y con este tamaño de esquinas $esquinas")
        super.inflar()

    }

}