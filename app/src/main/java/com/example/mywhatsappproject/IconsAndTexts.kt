package com.example.mywhatsappproject

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class IconsAndTexts(
    @DrawableRes var photoWha: Int,
    var nameWha: String,
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

    //VAriable para el menú que te permita visualizar el drop menu
    var showMenu by remember { mutableStateOf(false) }

    //Row para la imagen, el texto y el dropmenu...da igual el orden
    Row (
        modifier =
        Modifier.pointerInput(true){
        detectTapGestures (
            onLongPress = { showMenu = !showMenu}
        )
    }
    ){
        DropdownMenu(
            expanded = showMenu,
            onDismissRequest = {
                showMenu = false }
        ){
            DropdownMenuItem(
                text = {
                    Text(text = "Exit to group")
                       },
                onClick = { /*TODO*/ }
            )
            DropdownMenuItem(
                text = {
                    Text(text = "Info. group")
                       },
                onClick = { /*TODO*/ }
            )
            DropdownMenuItem(
                text = {
                    Text(text = "Create direct access")
                       },
                onClick = { /*TODO*/ }
            )
        }
        //La imagen
        Image(
            painter =
            painterResource(
                id = iconsAndTexts.photoWha
            ),
            contentDescription = "Photo whatsapp",
            modifier =
            Modifier
                .size(65.dp)
                .clip(shape = CircleShape
                ),
            contentScale = ContentScale.Crop
        )
        //La fila es para que el texto te salga centrado en vez de arriba (en medio)
        Row(
            modifier =
            Modifier
            .fillMaxWidth()
            .padding(
                top = 20.dp, start = 10.dp
            ),
        ) {
            Text(
                text = iconsAndTexts.nameWha,
                fontSize = 15.sp
            )
        }
    }
}