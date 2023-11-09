package com.example.mywhatsappproject

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource

data class IconsAndTexts(
    @DrawableRes var photoWha: Int,
    var nameWha: String
    var groupName: String
)

fun getIconsAndPic(): List<IconsAndTexts> {
    return listOf(
        IconsAndTexts(
            R.drawable.photo,
            "Jefe de departamento",
            "Departamento de informática"
        ),        IconsAndTexts(
            R.drawable.photo1,
            "Tutoria DAM",
            "Departamento de informática"
        ),        IconsAndTexts(
            R.drawable.photo2,
            "Tutoria DAW",
            "Departamento de informática"
        ),        IconsAndTexts(
            R.drawable.photo3,
            "Tutoria ASIX",
            "Departamento de informática"
        ),        IconsAndTexts(
            R.drawable.photo4,
            "Presidente",
            "Comunidad de propietarios"
        ),        IconsAndTexts(
            R.drawable.photo5,
            "Secretaria",
            "Comunidad de propietarios"
        ),        IconsAndTexts(
            R.drawable.photo6,
            "Administración",
            "Comunidad de propietarios"
        ),        IconsAndTexts(
            R.drawable.photo7,
            "Entrenadora",
            "Gimnasio"
        ),        IconsAndTexts(
            R.drawable.photo8,
            "Secretaria",
            "Gimnasio"
        ),        IconsAndTexts(
            R.drawable.photo9,
            "Fisioterapeuta",
            "Gimnasio"
        )
    )
}

@Composable
fun itemIconsAndPic(iconsAndTexts: IconsAndTexts){
    Row(
        Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Column {

            Row {
                Image(
                    painter = painterResource(id = iconsAndTexts.photoWha) ,
                    contentDescription = "Photo contact"
                )
            }
        }


    }
}