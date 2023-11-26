package com.dyshuk.android.factnumbers.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.dyshuk.android.factnumbers.domain.Number as NumberDomain

@Entity
data class NumberDb constructor(
    @PrimaryKey(autoGenerate = true)
    var primaryKey: Int = 0,
    val text: String,
    val number: Int,
    val found: Boolean,
    val type: String
)

fun NumberDb.asDomainModel(): NumberDomain {
    return NumberDomain(
        text = text,
        number = number,
        found = found,
        type = type
    )
}

fun List<NumberDb>.asListDomainModel(): List<NumberDomain> {
    return map {
        NumberDomain(
            text = it.text,
            number = it.number,
            found = it.found,
            type = it.type
        )
    }
}