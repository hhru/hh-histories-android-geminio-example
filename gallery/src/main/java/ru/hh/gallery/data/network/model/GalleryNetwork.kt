package ru.hh.gallery.data.network.model

import com.google.gson.annotations.SerializedName

internal data class GalleryNetwork(
    @SerializedName("photos")
    val photos: List<GalleryItemNetwork>? = emptyList(),
)

internal data class GalleryItemNetwork(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("photographer")
    val photographer: String? = null,
    @SerializedName("src")
    val src: ResourceItemNetwork? = null,
)

internal data class ResourceItemNetwork(
    @SerializedName("medium")
    val photo: String? = null,
)
