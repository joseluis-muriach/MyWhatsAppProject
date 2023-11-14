package com.example.mywhatsappproject

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun myTabs() {
    //Esto es para situarte en las pantallas (chat, novedades y llamadas) tenemos que hacerlo así
    //por que al añadir el corazon rotante cambia las librerias y por ende la versión
    var pagerState = rememberPagerState(initialPage = 0, initialPageOffsetFraction = 0f){3}
    //Permite navegar por el resto de pantallas
    var scope = rememberCoroutineScope()

    val titles = listOf("Chat", "Novedades", "Llamadas")
    Column {
        TabRow(
            containerColor = Color(0xFF039E72),
            contentColor = Color.White,
            selectedTabIndex = pagerState.currentPage
        ) {
            //Lanzas el scope
            titles.forEachIndexed { index, title -> //Le pasare 3el indice y el titulo
                Tab(
                    //Selecciona la pagina donde estas y lo iguala al indice
                    selected = pagerState.currentPage == index,
                    onClick = {
                        //Cuando cliques te lleva a la ventana
                        scope.launch {
                            pagerState.animateScrollToPage(page = index)
                        }
                    },
                    text = {
                        Text(
                            text = title,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                )
            }
        }
        //Esto te permite realizar la navegabilidad lateral
        HorizontalPager(
            state = pagerState) { page ->
            when (page) {
                0 -> chats()
                1 -> Novedades()
                2 ->Llamadas()
            }
        }
   }
}

@Composable
fun Llamadas() {
    Text(
        text = "Llamadas"
    )
}

@Composable
fun Novedades() {
    Text(
        text = "Novedades"
    )
}

