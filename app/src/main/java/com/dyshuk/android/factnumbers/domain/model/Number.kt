package com.dyshuk.android.factnumbers.domain.model

data class Number(
    val text: String,
    val number: Int,
    val found: Boolean,
    val type: String
)