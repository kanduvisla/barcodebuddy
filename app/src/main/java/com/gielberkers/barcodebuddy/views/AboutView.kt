package com.gielberkers.barcodebuddy.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gielberkers.barcodebuddy.BuildConfig
import com.gielberkers.barcodebuddy.R
import com.gielberkers.barcodebuddy.ui.theme.BarCodeBuddyTheme

@Composable
fun AboutView() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = stringResource(R.string.app_name),
            style = MaterialTheme.typography.h3
        )

        Text(
            text = "version " +BuildConfig.VERSION_NAME + "." + BuildConfig.VERSION_CODE.toString(),
            style = MaterialTheme.typography.caption
        )

        Divider()

        Text(
            text = stringResource(R.string.about_description),
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun AboutViewPreview() {
    BarCodeBuddyTheme {
        AboutView()
    }
}