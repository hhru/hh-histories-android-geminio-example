package ru.hh.blank.data.network.converter

import ru.hh.blank.data.model.BlankData
import ru.hh.blank.data.network.model.BlankItemNetwork
import ru.hh.blank.data.network.model.BlankNetwork
import toothpick.InjectConstructor

@InjectConstructor
internal class BlankNetworkDataConverter {
    fun convert(data: BlankNetwork): List<BlankData> {
        return data.photos?.mapNotNull(::convertBlank).orEmpty()
    }

    private fun convertBlank(model: BlankItemNetwork): BlankData? {
        if (model.id == null ) return null
        return BlankData(
            id = model.id.toString(),
            name = model.photographer.orEmpty(),
            url = model.src?.photo.orEmpty(),
        )
    }
}
