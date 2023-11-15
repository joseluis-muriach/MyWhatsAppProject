package com.example.mywhatsappproject

import androidx.compose.animation.graphics.ExperimentalAnimationGraphicsApi
import androidx.compose.animation.graphics.res.animatedVectorResource
import androidx.compose.animation.graphics.res.rememberAnimatedVectorPainter
import androidx.compose.animation.graphics.vector.AnimatedImageVector
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun myTabs() {
    //Esto es para situarte en las pantallas (chat, novedades y llamadas) tenemos que hacerlo así
    //por que al añadir el corazon rotante cambia las librerias y por ende la versión
    var pagerState = rememberPagerState(initialPage = 0, initialPageOffsetFraction = 0f) { 3 }
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
            state = pagerState
        ) { page ->
            when (page) {
                0 -> chats()
                1 -> Novedades()
                2 -> Llamadas()
            }
        }
    }
}

@OptIn(ExperimentalAnimationGraphicsApi::class)
@Composable
fun Llamadas() {
    //Aquí llamamos a "ic_smile" que es donde lo hemos enlazado con la rotación
    val image =
        AnimatedImageVector.animatedVectorResource(
            R.drawable.cara_smile
        )

    var atEnd by remember { mutableStateOf(false) }

    Image(
        alignment = Alignment.Center,
        painter = rememberAnimatedVectorPainter(image, atEnd),
        contentDescription = "VectorDrawable",
        modifier = Modifier.clickable {
            atEnd = !atEnd
        },
        contentScale = ContentScale.Crop
    )
}

@OptIn(ExperimentalAnimationGraphicsApi::class)
@Composable
fun Novedades() {
    //Aquí llamamos a "Pause play" que es donde lo hemos enlazado con la rotación
    val image =
        AnimatedImageVector.animatedVectorResource(
            R.drawable.pause_play
        )

    var atEnd by remember { mutableStateOf(false) }

    Image(
        alignment = Alignment.Center,
        painter = rememberAnimatedVectorPainter(image, atEnd),
        contentDescription = "VectorDrawable",
        modifier = Modifier.clickable {
            atEnd = !atEnd
        },
        contentScale = ContentScale.Crop
    )
}

