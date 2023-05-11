package com.gielberkers.barcodebuddy.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.DrawerValue
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.rememberDrawerState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.gielberkers.barcodebuddy.R
import com.gielberkers.barcodebuddy.ui.theme.BarCodeBuddyTheme
import com.gielberkers.barcodebuddy.views.components.DrawerContentButton
import kotlinx.coroutines.launch

@Composable
fun MainView() {
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    val coroutineScope = rememberCoroutineScope()
    val navController = rememberNavController()

    fun navigateTo(route: String) {
        navController.navigate(route)
        coroutineScope.launch {
            scaffoldState.drawerState.close()
        }
    }

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = {
                    Text(stringResource(R.string.app_name))
                },
                navigationIcon = {
                    IconButton(onClick = {
                        coroutineScope.launch {
                            scaffoldState.drawerState.open()
                        }
                    }) {
                        Icon(imageVector = Icons.Default.Menu, contentDescription = null)
                    }
                }
            )
        },
        drawerContent = {
            DrawerContentButton(icon = Icons.Default.Home, text = "Home") {
                navigateTo("home")
            }

            DrawerContentButton(icon = Icons.Default.Add, text = "Add Barcode") {
                navigateTo("add")
            }

            DrawerContentButton(icon = Icons.Default.Star, text = "About this App") {
                navigateTo("about")
            }

            Divider()

            TextButton(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 16.dp),
                onClick = { coroutineScope.launch {
                    scaffoldState.drawerState.close()
                } },
                content = {
                    Icon(imageVector = Icons.Default.Close, contentDescription = null)
                    Text("Close")
                }
            )
        },
        content = { padding ->
            // Change content according to selected option
            Column(
                modifier = Modifier
                    .padding(padding)
            ) {
                NavHost(
                    navController = navController,
                    startDestination = "home",
                    modifier = Modifier
                        .padding(all = 20.dp)
                ) {
                    composable("home") {
                        Text("Home")
                    }
                    composable("add") {
                        AddCardView()
                    }
                    composable("about") {
                        AboutView()
                    }
                }
            }
        }
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainViewPreview() {
    BarCodeBuddyTheme {
        MainView()
    }
}