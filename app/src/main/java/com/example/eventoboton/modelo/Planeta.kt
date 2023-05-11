package com.example.eventoboton.modelo

import android.os.Parcel
import android.os.Parcelable

data class Planeta(
    var nombre: String,
    val atmosfera: Float,
    val distancia: Int,
    var nombreLuna: String,
    var diaSemana: String?) : Parcelable{

     constructor(parcel: Parcel) : this (
    parcel.readString()!!,
    parcel.readFloat(),
    parcel.readInt(),
    parcel.readString()!!,
    parcel.readString())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nombre)
        parcel.writeFloat(atmosfera)
        parcel.writeInt(distancia)
        parcel.writeString(nombreLuna)
        parcel.writeString(diaSemana)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Planeta> {
        override fun createFromParcel(parcel: Parcel): Planeta {
            return Planeta(parcel)
        }

        override fun newArray(size: Int): Array<Planeta?> {
            return arrayOfNulls(size)
        }
    }

}
