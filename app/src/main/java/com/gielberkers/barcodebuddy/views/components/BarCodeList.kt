package com.gielberkers.barcodebuddy.views.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gielberkers.barcodebuddy.data.BarCode

@Composable
fun BarCodeList(barCodes: List<BarCode>) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(all = 20.dp)
    ) {
        items(barCodes) {
            BarCodeCard(barCode = it)
        }
    }
}

@Composable
@Preview(showSystemUi = true, showBackground = true)
fun BarCodeListPreview() {
    BarCodeList(
        barCodes = listOf(
            BarCode(name = "Store #1", code = "2620633371049"),
            BarCode(name = "Store #2", code = "2622642378002"),
            BarCode(name = "Store #3", code = "2620633371049")
        )
    )
}