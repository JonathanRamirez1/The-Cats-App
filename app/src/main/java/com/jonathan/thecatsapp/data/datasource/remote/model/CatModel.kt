package com.jonathan.thecatsapp.data.datasource.remote.model

import com.google.gson.annotations.SerializedName
import com.jonathan.thecatsapp.domain.model.Cats

data class CatModel(
    @SerializedName("id") val id: String? = null,
    @SerializedName("name") val name: String? = null,
    @SerializedName("origin") val origin: String? = null,
    @SerializedName("affection_level") val affectionLevel: Int? = null,
    @SerializedName("intelligence") val intelligence: Int? = null,
    @SerializedName("reference_image_id") val imageUrl: String? = null
)

fun CatModel.toCat() = Cats(
    this.id,
    this.name,
    this.origin,
    this.affectionLevel,
    this.intelligence,
    this.imageUrl
)
