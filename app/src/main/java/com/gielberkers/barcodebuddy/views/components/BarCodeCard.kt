package com.gielberkers.barcodebuddy.views.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gielberkers.barcodebuddy.data.BarCode
import com.gielberkers.barcodebuddy.ui.theme.BarCodeBuddyTheme
import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatWriter
import com.journeyapps.barcodescanner.BarcodeEncoder
import java.lang.Exception

fun createBitmap(code: String): ImageBitmap? {
    val multiFormatWriter = MultiFormatWriter()
    return try {
        val bitMatrix = multiFormatWriter.encode(
            code,
            BarcodeFormat.EAN_13,
            400,
            80
        )
        val barcodeEncoder = BarcodeEncoder()
        val bitmap = barcodeEncoder.createBitmap(bitMatrix)
        bitmap.asImageBitmap()
    } catch (e: Exception) {
        null
    }
}

@Composable
fun BarCodeCard(
    barCode: BarCode,
    onClick: () -> Unit = {}
) {
    Card(
        elevation = 5.dp,
        modifier = Modifier.clickable { onClick() }
    ) {
        Surface(modifier = Modifier
            .padding(all = 20.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                val bitmap = createBitmap(barCode.code)
                if (bitmap != null) {
                    Image(
                        bitmap = bitmap,
                        contentDescription = null,
                        modifier = Modifier
                            .height(80.dp)
                            .fillMaxWidth()
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(barCode.name)
                    Text(barCode.code)
                }
            }
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