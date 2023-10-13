package com.dyshuk.android.factnumbers.network.model

import com.dyshuk.android.factnumbers.domain.Number
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NumberDto(
    @Json(name = "text") val text: String,
    val number: Int,
    val found: Boolean,
    val type: String
)

fun NumberDto.asDomainModel(): Number {
    return Number(
        text = text,
        number = number,
        found = found,
        type = type
    )
}