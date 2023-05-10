package com.gielberkers.barcodebuddy.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.DrawerValue
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.rememberDrawerState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.gielberkers.barcodebuddy.ui.theme.BarCodeBuddyTheme

@Composable
fun MainView() {
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = {
                    Text("BarCodeBuddy")
                },
                navigationIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        
                    }
                }
            )
        },
        drawerContent = {
            Text(text = "DrawerContent")
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

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    BarCodeBuddyTheme {
        MainView()
    }
}