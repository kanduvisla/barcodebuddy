package com.gielberkers.barcodebuddy.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gielberkers.barcodebuddy.data.DatabaseHelper
import com.gielberkers.barcodebuddy.ui.theme.BarCodeBuddyTheme
import com.gielberkers.barcodebuddy.views.components.BarCodeCard

@Composable
fun HomeView() {
    val db = DatabaseHelper.getAppDatabase(LocalContext.current)
    val barCodes = db.barCodeDao().getAll()

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(barCodes) {
            BarCodeCard(barCode = it)
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun HomeViewPreview() {
    BarCodeBuddyTheme {
        HomeView()
    }
}