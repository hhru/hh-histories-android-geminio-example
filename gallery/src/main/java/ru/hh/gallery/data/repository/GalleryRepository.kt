package ru.hh.gallery.data.repository

import androidx.paging.PagingData
import io.reactivex.Observable
import ru.hh.gallery.data.model.GalleryModel
import ru.hh.gallery.data.paging.GalleryPager
import toothpick.InjectConstructor

@InjectConstructor
internal class GalleryRepository(
    private val pager: GalleryPager,
) {

    fun getGallery(): Observable<PagingData<GalleryModel>> = pager.getPager()

}
