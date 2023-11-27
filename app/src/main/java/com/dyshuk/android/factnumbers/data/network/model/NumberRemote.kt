package com.dyshuk.android.factnumbers.data.network.model

import com.dyshuk.android.factnumbers.data.database.model.NumberDb
import com.dyshuk.android.factnumbers.domain.model.Number as NumberDomain
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NumberRemote(
    @Json(name = "text") val text: String,
    val number: Int,
    val found: Boolean,
    val type: String
)

fun NumberRemote.asDomainModel(): NumberDomain {
    return NumberDomain(
        text = text,
        number = number,
        found = found,
        type = type
    )
}

fun NumberRemote.asDatabaseModel(): NumberDb {
    return NumberDb(
        text = text,
        number = number,
        found = found,
        type = type
    )
}