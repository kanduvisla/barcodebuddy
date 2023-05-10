package com.gielberkers.barcodebuddy.views.components

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.gielberkers.barcodebuddy.ui.theme.BarCodeBuddyTheme

@Composable
fun DrawerContent() {
    Column {

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    BarCodeBuddyTheme {
        DrawerContent()
    }
}