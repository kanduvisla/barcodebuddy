package com.gielberkers.barcodebuddy.views

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
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

    Column {
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