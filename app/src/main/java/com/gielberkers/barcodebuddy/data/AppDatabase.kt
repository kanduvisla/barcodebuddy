package com.gielberkers.barcodebuddy.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [BarCode::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun barCodeDao(): BarCodeDao
}

class DatabaseHelper {
    @Volatile
    private var appDatabase: AppDatabase? = null

    fun getAppDatabase(ctx: Context): AppDatabase {
        if (appDatabase == null) {
            synchronized(this) {
                if (appDatabase == null) {
                    appDatabase = Room.databaseBuilder(
                        ctx,
                        AppDatabase::class.java, "app-database"
                    )
                    .build()
                }
            }
        }
        return appDatabase!!
    }
}