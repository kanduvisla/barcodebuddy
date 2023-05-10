package com.gielberkers.barcodebuddy.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.rememberDrawerState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gielberkers.barcodebuddy.ui.theme.BarCodeBuddyTheme
import kotlinx.coroutines.launch

@Composable
fun MainView() {
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Open))
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = {
                    Text("BarCodeBuddy")
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
            DrawerContentButton(icon = Icons.Default.Add, text = "Add Barcode") {
                
            }

            DrawerContentButton(icon = Icons.Default.Star, text = "About this App") {

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
            Column(
                modifier = Modifier
                    .padding(padding)
            ) {
                Text("BodyContent")
            }
        }
    )
}

@Composable
fun DrawerContentButton(
    icon: ImageVector,
    text: String,
    onClick: () -> Unit
) {
    TextButton(
        onClick = onClick
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Icon(imageVector = icon, contentDescription = null)
            Text(text)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    BarCodeBuddyTheme {
        MainView()
    }
}