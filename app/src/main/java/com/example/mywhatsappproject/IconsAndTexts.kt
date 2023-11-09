package com.example.mywhatsappproject

import androidx.annotation.DrawableRes

data class IconsAndTexts(
    @DrawableRes var photoSol: Int,
    var nameSol: String
)

fun getIconsAndPic(): List<IconsAndTexts> {
    return listOf(
        IconsAndTexts(
            R.drawable.photo,
            "Jefe de departamento"
        ),        IconsAndTexts(
            R.drawable.photo1,
            "Tutoria DAM"
        ),        IconsAndTexts(
            R.drawable.photo2,
            "Tutoria DAW"
        ),        IconsAndTexts(
            R.drawable.photo3,
            "Tutoria ASIX"
        ),        IconsAndTexts(
            R.drawable.photo4,
            "Presidente"
        ),        IconsAndTexts(
            R.drawable.photo5,
            "Secretaria"
        ),        IconsAndTexts(
            R.drawable.photo6,
            "Administración"
        ),        IconsAndTexts(
            R.drawable.photo7,
            "Entrenadora"
        ),        IconsAndTexts(
            R.drawable.photo8,
            "Secretaria"
        ),        IconsAndTexts(
            R.drawable.photo9,
            "Fisioterapeuta"
        )
    )
}
