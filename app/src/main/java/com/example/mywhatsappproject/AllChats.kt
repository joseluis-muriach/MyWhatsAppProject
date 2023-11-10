package com.example.mywhatsappproject

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun chats() {

    //Variable para coger el nombre del grupo
    val grupo = getIconsAndPic().groupBy { it.groupName }

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        //Iterará los contactos por grupos
        grupo.forEach { (publisher, myContact) ->
            stickyHeader {//La barra gris
                Text(
                    text = publisher,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.LightGray), fontSize = 16.sp
                )
            }
            //Itera los contactos por grupo
            items(myContact) { lazy ->
                itemIconsAndPic(
                    iconsAndTexts = lazy
                )
            }
        }
    }
}