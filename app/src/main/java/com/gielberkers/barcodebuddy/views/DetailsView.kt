package com.gielberkers.barcodebuddy.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gielberkers.barcodebuddy.data.BarCode
import com.gielberkers.barcodebuddy.data.DatabaseHelper
import com.gielberkers.barcodebuddy.ui.theme.BarCodeBuddyTheme
import com.gielberkers.barcodebuddy.views.components.BarCodeCard

@Composable
fun DetailsViewByUID(barCodeUID: Int) {
    val db = DatabaseHelper.getAppDatabase(LocalContext.current)
    val barCode = db.barCodeDao().get(uid = barCodeUID)
    DetailsView(barCode = barCode)
}

@Composable
fun DetailsView(barCode: BarCode) {
    Column(
        Modifier
            .background(color = MaterialTheme.colors.onBackground)
            .padding(20.dp)
            .fillMaxHeight()
    ) {
        BarCodeCard(barCode = barCode)
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun DetailsViewPreview() {
    BarCodeBuddyTheme {
        DetailsView(barCode = BarCode(name = "Example", code = "2620633371049"))
    }
}