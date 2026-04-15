package com.example.notesapp_msabo

import java.util.UUID

data class Note(
    val id: String = UUID.randomUUID().toString(),
    val naslov: String,
    val opis: String
)