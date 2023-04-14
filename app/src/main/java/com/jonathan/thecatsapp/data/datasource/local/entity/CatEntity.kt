package com.jonathan.thecatsapp.data.datasource.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.jonathan.thecatsapp.domain.model.Cats

@Entity(tableName = "cats_table")
data class CatEntity (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: String? = null,
    @ColumnInfo(name = "name")
    val name: String? = null,
    @ColumnInfo(name = "origin")
    val origin: String? = null,
    @ColumnInfo(name = "affection_level")
    val affectionLevel: Int? = null,
    @ColumnInfo(name = "intelligence")
    val intelligence: Int? = null,
    @ColumnInfo(name = "reference_image_id")
    val imageUrl: String? = null
)

fun CatEntity.toCats() = Cats(
    this.id,
    this.name,
    this.origin,
    this.affectionLevel,
    this.intelligence,
    this.imageUrl
)