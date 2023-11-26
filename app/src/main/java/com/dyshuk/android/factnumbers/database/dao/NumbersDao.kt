package com.dyshuk.android.factnumbers.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dyshuk.android.factnumbers.database.model.NumberDb

@Dao
interface NumbersDao {
    @Query("SELECT * FROM NumberDb")
    fun getNumbers(): LiveData<List<NumberDb>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertNumber(number: NumberDb)
}