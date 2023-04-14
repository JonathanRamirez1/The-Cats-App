package com.jonathan.thecatsapp.domain.model

import com.jonathan.thecatsapp.data.datasource.local.entity.CatEntity

data class Cats(
    val id: String? = null,
    val name: String? = null,
    val origin: String? = null,
    val affectionLevel: Int? = null,
    val intelligence: Int? = null,
    val imageUrl: String? = null
)

fun Cats.toCatEntity() = CatEntity(
    this.id,
    this.name,
    this.origin,
    this.affectionLevel,
    this.intelligence,
    this.imageUrl
)
