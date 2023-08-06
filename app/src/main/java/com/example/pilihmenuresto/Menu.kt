package com.example.pilihmenuresto
import android.os.Parcelable
import kotlinx.parcelize.Parcelize
@Parcelize

data class Menu(
    val listMenu: String?,
    val listDescription: String?,
    val listHarga: Int,
    val listFoto:Int?
) : Parcelable
