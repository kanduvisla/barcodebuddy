package com.gielberkers.barcodebuddy.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gielberkers.barcodebuddy.R
import com.gielberkers.barcodebuddy.data.BarCode
import com.gielberkers.barcodebuddy.data.DatabaseHelper
import com.gielberkers.barcodebuddy.ui.theme.BarCodeBuddyTheme

@Composable
fun AddCardManualView() {
    val enteredBarcode = remember { mutableStateOf("") }
    val enteredName = remember { mutableStateOf("") }
    val db = DatabaseHelper.getAppDatabase(LocalContext.current)

    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Surface(
            modifier = Modifier
                .padding(20.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.add_card_manual_title),
                    style = MaterialTheme.typography.h6
                )

                Text(
                    text = stringResource(id = R.string.add_card_name),
                    style = MaterialTheme.typography.body1
                )

                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = enteredName.value,
                    onValueChange = {
                        enteredName.value = it
                    }
                )

                Text(
                    text = stringResource(id = R.string.add_card_number),
                    style = MaterialTheme.typography.body1
                )

                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    TextField(
                        modifier = Modifier.weight(1f),
                        value = enteredBarcode.value,
                        onValueChange = {
                            enteredBarcode.value = it
                        }
                    )

                    IconButton(onClick = {
                        db.barCodeDao().insertAll(
                            BarCode(name = enteredName.value, code = enteredBarcode.value)
                        )
                    }) {
                        Icon(imageVector = Icons.Default.Add, contentDescription = null)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AddCardManualViewPreview() {
    BarCodeBuddyTheme {
        AddCardManualView()
    }
}