package com.dyshuk.android.factnumbers.network.model

import com.dyshuk.android.factnumbers.database.model.DbNumber
import com.dyshuk.android.factnumbers.domain.Number as AppNumber
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NumberDto(
    @Json(name = "text") val text: String,
    val number: Int,
    val found: Boolean,
    val type: String
)

fun NumberDto.asDomainModel(): AppNumber {
    return AppNumber(
        text = text,
        number = number,
        found = found,
        type = type
    )
}

fun NumberDto.asDatabaseModel(): DbNumber {
    return DbNumber(
        text = text,
        number = number,
        found = found,
        type = type
    )
}