package com.gielberkers.barcodebuddy.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface BarCodeDao {
    @Query("SELECT * FROM BarCode WHERE uid =:uid")
    fun get(uid: Int): BarCode

    @Query("SELECT * FROM BarCode")
    fun getAll(): List<BarCode>

    @Insert
    fun insertAll(vararg barCodes: BarCode)

    @Delete
    fun delete(barCode: BarCode)
}