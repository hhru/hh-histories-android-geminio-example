package ru.hh.gallery.data.network.di

import ru.hh.core.network.ApiFactory
import ru.hh.gallery.data.network.api.GalleryHttpApi
import toothpick.InjectConstructor
import javax.inject.Provider

@InjectConstructor
internal class GalleryHttpApiProvider : Provider<GalleryHttpApi> {

    override fun get() = ApiFactory.createApi(GalleryHttpApi::class.java)

}