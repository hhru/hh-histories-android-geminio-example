package ru.hh.blank.data.network.model

import com.google.gson.annotations.SerializedName

internal data class BlankNetwork(
    @SerializedName("photos")
    val photos: List<BlankItemNetwork>? = emptyList(),
)

internal data class BlankItemNetwork(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("photographer")
    val photographer: String? = null,
    @SerializedName("src")
    val src: BlankResourceNetwork? = null,
)

internal data class BlankResourceNetwork(
    @SerializedName("medium")
    val photo: String? = null,
)
