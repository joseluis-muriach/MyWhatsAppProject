package com.example.mywhatsappproject

import androidx.compose.foundation.ExperimentalFoundationApi

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OguetaMyWhatsappTheme {
                val scrollBehavior =
                    TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())
                Scaffold(
                    modifier = Modifier
                        .nestedScroll(scrollBehavior.nestedScrollConnection)
                        .fillMaxSize(),
                    containerColor = MaterialTheme.colorScheme.background,
                    topBar = { MyTopAppBar(scrollBehavior) },
                    floatingActionButton = {
                        FloatingActionButton(
                            onClick = { },
                            containerColor = WhatsappDarkGreen
                        ) {
                            Icon(
                                imageVector = Icons.Default.Check,
                                contentDescription = "Check",
                                tint = Color.White
                            )
                        }
                    },
                    floatingActionButtonPosition = FabPosition.End
                ) {


                    var pagerState = rememberPagerState(initialPage = 0)
                    var scope = rememberCoroutineScope()


                    Box(modifier = Modifier.padding(top = it.calculateTopPadding())) {
                        var state by remember { mutableStateOf(0) }
                        val titles = listOf("Chat", "Novedades", "Llamadas")
                        Column {
                            TabRow(
                                containerColor = WhatsappGreen,
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
                            HorizontalPager(pageCount = 3, state = pagerState) { page ->
                                when (page) {
                                    0 -> {
                                        Chat()
                                    }


                                    1 -> {
                                        Novedades()
                                    }


                                    2 -> {
                                        Llamadas()
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
