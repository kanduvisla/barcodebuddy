package com.gielberkers.barcodebuddy.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [BarCode::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun barCodeDao(): BarCodeDao
}