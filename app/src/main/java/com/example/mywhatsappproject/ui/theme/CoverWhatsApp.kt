package com.example.mywhatsappproject.ui.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.mywhatsappproject.topAppBarWhat

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun coverW() {
    //Creamos la columna donde haremos todo
    Column(
        Modifier.fillMaxSize()
    ) {
        //Ahora pondremos la top app bar con el Scafold por que es necesario
        Scaffold(
            topBar = { topAppBarWhat() }
        ) {

            //Columna para meterlo todo y que calcule el padding
            Column(
                modifier =
                Modifier
                    .fillMaxWidth()
                    //Para que salga justo abajo de la top app bar
                    .padding(top = it.calculateTopPadding())
            ) {

                //Aquí creamos la fila donde ira "chat", "novedades" y "Llamadas"
                Row(
                    modifier =
                    Modifier
                        .fillMaxWidth()
                        //Para pintar el fondo de la fila
                        .background(Color(0xFF039E72)),
                    horizontalArrangement = Arrangement.Center
                ) {//Ponemos los textos
                    Text(
                        text = "Chat",
                        modifier = Modifier
                            //Para centrar el texto en su hueco
                            .align(Alignment.CenterVertically)
                            .weight(2f)
                            .padding(8.dp)
                            .clickable { },
                        color = Color.White
                    )
                    Text(
                        text = "Novedades",
                        modifier = Modifier
                            //Para centrar el texto en su hueco
                            .align(Alignment.CenterVertically)
                            .weight(2f)
                            .padding(8.dp)
                            .clickable { },
                        color = Color.White
                    )
                    Text(
                        text = "Llamadas",
                        modifier = Modifier
                            //Para centrar el texto en su hueco
                            .align(Alignment.CenterVertically)
                            .weight(1.5f)
                            .padding(8.dp)
                            .clickable { },
                        color = Color.White
                    )
                }

                Row(
                    modifier =
                    Modifier
                        .fillMaxWidth()
                    //Para que salga justo abajo de la top app bar
                ) {
                    Text(text = "hioa")
                }
            }
        }
    }
}