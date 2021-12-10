package ru.hh.gallery.data.network.converter

import ru.hh.gallery.data.model.GalleryModel
import ru.hh.gallery.data.network.model.GalleryItemNetwork
import ru.hh.gallery.data.network.model.GalleryNetwork
import toothpick.InjectConstructor

@InjectConstructor
internal class GalleryNetworkConverter {

    fun convert(networkModel: GalleryNetwork): List<GalleryModel> {
        return networkModel.photos?.map(::convertItem).orEmpty()
    }

    private fun convertItem(item: GalleryItemNetwork) : GalleryModel {
        return GalleryModel(
            id = item.id.toString(),
            name = item.photographer.orEmpty(),
            url = item.src?.photo.orEmpty(),
        )
    }
}
