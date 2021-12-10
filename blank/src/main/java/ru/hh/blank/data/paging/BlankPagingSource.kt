package ru.hh.blank.data.paging

import androidx.paging.PagingState
import androidx.paging.rxjava2.RxPagingSource
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import ru.hh.blank.data.model.BlankData
import ru.hh.blank.data.network.api.BlankApi
import ru.hh.blank.data.network.converter.BlankNetworkDataConverter
import toothpick.InjectConstructor

@InjectConstructor
internal class BlankPagingSource(
    private val apiClient: BlankApi,
    private val converter: BlankNetworkDataConverter,
) : RxPagingSource<Int, BlankData>() {
    override fun loadSingle(params: LoadParams<Int>): Single<LoadResult<Int, BlankData>> {
        val page = params.key ?: 0
        val nextKey = page + 1
        val prevKey = if (page == 1) null else page - 1
        return apiClient.getBlankList(page = page, perPage = params.loadSize)
            .subscribeOn(Schedulers.io())
            .map {
                LoadResult.Page(
                    data = converter.convert(it),
                    prevKey = prevKey,
                    nextKey = nextKey,
                )
            }
    }

    override fun getRefreshKey(state: PagingState<Int, BlankData>): Int? {
        val anchorPosition = state.anchorPosition ?: return null
        val page = state.closestPageToPosition(anchorPosition) ?: return null
        return page.prevKey?.plus(1) ?: page.nextKey?.minus(1)
    }
}
