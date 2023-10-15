package com.dyshuk.android.factnumbers.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.dyshuk.android.factnumbers.domain.Number as AppNumber

@Entity
data class DbNumber constructor(
    @PrimaryKey(autoGenerate = true)
    var primaryKey: Int = 0,
    val text: String,
    val number: Int,
    val found: Boolean,
    val type: String
)

fun DbNumber.asDomainModel(): AppNumber {
    return AppNumber(
        text = text,
        number = number,
        found = found,
        type = type
    )
}

fun List<DbNumber>.asListDomainModel(): List<AppNumber> {
    return map {
        AppNumber(
            text = it.text,
            number = it.number,
            found = it.found,
            type = it.type
        )
    }
}