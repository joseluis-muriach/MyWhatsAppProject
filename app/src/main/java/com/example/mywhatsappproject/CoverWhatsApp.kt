package com.example.mywhatsappproject

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun coverW() {
    //Creamos la columna donde haremos todo
    Column(
        Modifier.fillMaxSize()
    ) {
        //Variable para que la Top desaparezca cuando hagamos scroll
        val scrollBehavior =
            TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState()
        )
        //Ahora pondremos la top app bar con el Scafold por que es necesario
        Scaffold(
            //Le he añadido esto para que tenga la funcionalidad
            modifier = Modifier
                .nestedScroll(scrollBehavior.nestedScrollConnection),
            topBar = {
                topAppBarWhat(scrollBehavior)
            },
            floatingActionButton = {
                floatingButtom()
            }
        ) {

            //Columna para meterlo todo y que calcule el padding
            Column(
                modifier =
                Modifier
                    //Para que salga justo abajo de la top app bar
                    .padding(top = it.calculateTopPadding())
            ) {
                myTabs()
            }
        }
    }
}