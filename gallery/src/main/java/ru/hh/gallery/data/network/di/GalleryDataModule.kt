package ru.hh.gallery.data.network.di

import ru.hh.gallery.data.network.api.GalleryHttpApi
import ru.hh.gallery.data.repository.GalleryRepository
import toothpick.config.Module
import toothpick.ktp.binding.bind

internal class GalleryDataModule : Module() {

    init {
        bind<GalleryHttpApi>().toProvider(GalleryHttpApiProvider::class).singleton()
        bind<GalleryRepository>().singleton()
    }

}