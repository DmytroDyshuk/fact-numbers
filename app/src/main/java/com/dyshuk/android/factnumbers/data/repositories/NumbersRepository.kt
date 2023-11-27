package com.dyshuk.android.factnumbers.data.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.dyshuk.android.factnumbers.data.database.NumbersDatabase
import com.dyshuk.android.factnumbers.data.database.model.NumberDb
import com.dyshuk.android.factnumbers.data.database.model.asListDomainModel
import com.dyshuk.android.factnumbers.data.network.RetrofitService
import com.dyshuk.android.factnumbers.data.network.model.asDatabaseModel
import com.dyshuk.android.factnumbers.data.network.model.asDomainModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import com.dyshuk.android.factnumbers.domain.model.Number as AppNumber

class NumbersRepository(private val numbersDatabase: NumbersDatabase) {

    val numbers: LiveData<List<AppNumber>> = numbersDatabase.numbersDao.getNumbers().map {
        it.asListDomainModel()
    }

    suspend fun getMathNumber(number: Int): AppNumber = withContext(Dispatchers.IO) {
        val mathNumber = RetrofitService.numberApiService.getMathNumber(number)
        saveNumberToDatabase(mathNumber.asDatabaseModel())
        return@withContext mathNumber.asDomainModel()
    }

    suspend fun getRandomNumber(): AppNumber = withContext(Dispatchers.IO) {
        val randomNumber = RetrofitService.numberApiService.getRandomNumber()
        saveNumberToDatabase(randomNumber.asDatabaseModel())
        return@withContext randomNumber.asDomainModel()
    }

    private fun saveNumberToDatabase(number: NumberDb) {
        numbersDatabase.numbersDao.insertNumber(number)
    }

}