package com.example.mywhatsappproject.ui.theme

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun myTabs() {
    var pagerState = rememberPagerState(initialPage = 0)
    var scope = rememberCoroutineScope()

    val titles = listOf("Chat", "Novedades", "Llamadas")
    Column {
        TabRow(
            containerColor = Color(0xFF039E72),
            contentColor = Color.White,
            selectedTabIndex = pagerState.currentPage
        ) {
            titles.forEachIndexed { index, title ->
                Tab(
                    selected = pagerState.currentPage == index,
                    onClick = {
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
//        HorizontalPager(pageCount = 3, state = pagerState) { page ->
//            when (page) {
//                0 -> {
//                    Chat()
//                }
//
//
//                1 -> {
//                    Novedades()
//                }
//
//
//                2 -> {
//                    Llamadas()
//                }
//            }
//        }
    }
}

@Composable
fun Llamadas() {
    TODO("Not yet implemented")
}

@Composable
fun Novedades() {
    TODO("Not yet implemented")
}

@Composable
fun Chat() {
    TODO("Not yet implemented")
}
