package com.gielberkers.barcodebuddy.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gielberkers.barcodebuddy.ui.theme.BarCodeBuddyTheme
import com.google.mlkit.vision.barcode.BarcodeScannerOptions
import com.google.mlkit.vision.barcode.common.Barcode

@Composable
fun AddCardView() {
    // TODO: Use camera + barcode scanner:
    val options = BarcodeScannerOptions.Builder()
        .enableAllPotentialBarcodes()
        .setBarcodeFormats(
            Barcode.FORMAT_UPC_A,
            Barcode.FORMAT_UPC_E
        )
        .build()

    Column(
        Modifier.padding(20.dp)
    ) {
        // Manual Entry:
        AddCardManualView()
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AddCardViewPreview() {
    BarCodeBuddyTheme {
        AddCardView()
    }
}