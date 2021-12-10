package ru.hh.gallery.data.paging

import androidx.paging.PagingState
import androidx.paging.rxjava2.RxPagingSource
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import ru.hh.gallery.data.model.GalleryModel
import ru.hh.gallery.data.network.api.GalleryHttpApi
import ru.hh.gallery.data.network.converter.GalleryNetworkConverter
import toothpick.InjectConstructor

@InjectConstructor
internal class GalleryPagingSource(
    private val apiClient: GalleryHttpApi,
    private val converter: GalleryNetworkConverter,
) : RxPagingSource<Int, GalleryModel>() {
    override fun loadSingle(params: LoadParams<Int>): Single<LoadResult<Int, GalleryModel>> {
        val page = params.key ?: 0
        val nextKey = page + 1
        val prevKey = if (page == 1) null else page - 1
        return apiClient.getGallery(page, params.loadSize)
            .subscribeOn(Schedulers.io())
            .map{
                LoadResult.Page(
                    data = converter.convert(it),
                    prevKey = prevKey,
                    nextKey = nextKey,
                )
            }
    }

    override fun getRefreshKey(state: PagingState<Int, GalleryModel>): Int? {
        val anchorPosition = state.anchorPosition ?: return null
        val page = state.closestPageToPosition(anchorPosition) ?: return null
        return page.prevKey?.plus(1) ?: page.nextKey?.minus(1)
    }
}
