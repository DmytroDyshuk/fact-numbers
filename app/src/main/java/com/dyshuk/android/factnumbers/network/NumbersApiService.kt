package com.dyshuk.android.factnumbers.network

import com.dyshuk.android.factnumbers.network.model.NumberDto
import retrofit2.http.GET
import retrofit2.http.Path

interface NumbersApiService {
    @GET("{number}/math?json")
    suspend fun getMathNumber(@Path ("number") number: Int): NumberDto

    @GET("{number}/trivia?json")
    suspend fun getTriviaNumber(@Path ("number") number: Int): NumberDto

    @GET("random?json")
    suspend fun getRandomNumber(): NumberDto
}