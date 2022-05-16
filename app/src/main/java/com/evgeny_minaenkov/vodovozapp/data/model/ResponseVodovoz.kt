package com.evgeny_minaenkov.vodovozapp.data.model

data class ResponseVodovoz(
    val TOVARY: List<TOVARY>,
    val message: String,
    val status: String
)