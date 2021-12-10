package ru.hh.gallery.data.paging

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.rxjava2.observable
import io.reactivex.Observable
import ru.hh.gallery.data.model.GalleryModel
import toothpick.InjectConstructor

@InjectConstructor
internal class GalleryPager(
    private val pagingSource: GalleryPagingSource,
) {
    private companion object {
        const val PAGE_SIZE = 10
        const val PREFETCH_DISTANCE = 1
        const val INITIAL_KEY = 1
    }

    fun getPager(): Observable<PagingData<GalleryModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = PAGE_SIZE,
                initialLoadSize = PAGE_SIZE,
                prefetchDistance = PREFETCH_DISTANCE,
            ),
            initialKey = INITIAL_KEY,
            pagingSourceFactory = { pagingSource },
        ).observable
    }
}
