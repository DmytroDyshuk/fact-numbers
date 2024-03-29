package com.dyshuk.android.factnumbers.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.dyshuk.android.factnumbers.data.database.dao.NumbersDao
import com.dyshuk.android.factnumbers.data.database.model.NumberDb

@Database(entities = [NumberDb::class], version = 1)
abstract class NumbersDatabase : RoomDatabase() {
    abstract val numbersDao: NumbersDao
}

private lateinit var INSTANCE: NumbersDatabase

fun getDatabase(context: Context): NumbersDatabase {
    synchronized(NumbersDatabase::class.java) {
        if (::INSTANCE.isInitialized) {
            INSTANCE = Room.databaseBuilder(context.applicationContext, NumbersDatabase::class.java, "numbers")
                .build()
        }
    }
    return INSTANCE
}