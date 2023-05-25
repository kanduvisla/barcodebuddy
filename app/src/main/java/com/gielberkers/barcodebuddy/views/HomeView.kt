package com.gielberkers.barcodebuddy.views

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.gielberkers.barcodebuddy.data.DatabaseHelper
import com.gielberkers.barcodebuddy.ui.theme.BarCodeBuddyTheme
import com.gielberkers.barcodebuddy.views.components.BarCodeList

@Composable
fun HomeView(navController: NavController) {
    val db = DatabaseHelper.getAppDatabase(LocalContext.current)
    val barCodes = db.barCodeDao().getAll()

    BarCodeList(
        barCodes = barCodes,
        navController = navController
    )
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun HomeViewPreview() {
    BarCodeBuddyTheme {
        HomeView(navController = rememberNavController())
    }
}