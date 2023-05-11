package com.gielberkers.barcodebuddy.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class BarCode(
    var name: String,
    var code: String
) {
    @PrimaryKey(autoGenerate = true) var uid: Int = 0
}
