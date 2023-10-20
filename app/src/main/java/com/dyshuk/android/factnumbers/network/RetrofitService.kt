package com.dyshuk.android.factnumbers.network

import com.dyshuk.android.factnumbers.utils.constants.Constants.NUMBERS_BASE_URL
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(NUMBERS_BASE_URL)
    .build()

object RetrofitService {
    val numberApiService: NumbersApiService by lazy {
        retrofit.create(NumbersApiService::class.java)
    }
}