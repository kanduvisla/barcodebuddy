package com.gielberkers.barcodebuddy.views

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.gielberkers.barcodebuddy.ui.theme.BarCodeBuddyTheme

@Composable
fun HomeView() {

}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun HomeViewPreview() {
    BarCodeBuddyTheme {
        HomeView()
    }
}