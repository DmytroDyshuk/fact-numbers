package com.dyshuk.android.factnumbers.data.network.api

import com.dyshuk.android.factnumbers.data.network.model.NumberRemote
import retrofit2.http.GET
import retrofit2.http.Path

interface NumbersApiService {
    @GET("{number}/math?json")
    suspend fun getMathNumber(@Path("number") number: Int): NumberRemote

    @GET("{number}/trivia?json")
    suspend fun getTriviaNumber(@Path("number") number: Int): NumberRemote

    @GET("random?json")
    suspend fun getRandomNumber(): NumberRemote
}