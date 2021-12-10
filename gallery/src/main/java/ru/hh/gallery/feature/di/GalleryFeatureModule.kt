package ru.hh.gallery.feature.di

import ru.hh.gallery.feature.GalleryFeature
import toothpick.config.Module
import toothpick.ktp.binding.bind

internal class GalleryFeatureModule : Module() {

    init {
        bind<GalleryFeature>().singleton()
    }

}