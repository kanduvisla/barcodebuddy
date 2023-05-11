package com.gielberkers.barcodebuddy.views.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gielberkers.barcodebuddy.data.BarCode
import com.gielberkers.barcodebuddy.ui.theme.BarCodeBuddyTheme

@Composable
fun BarCodeCard(barCode: BarCode) {
    Card {
        Surface(modifier = Modifier.padding(all = 20.dp)) {

        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BarCodeCardPreview() {
    BarCodeBuddyTheme {
        BarCodeCard(barCode = BarCode(name = "Jumbo", code = "2620633371049"))
    }
}