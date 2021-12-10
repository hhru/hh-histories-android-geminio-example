package ${packageName}.paging

import androidx.paging.PagingState
import androidx.paging.rxjava2.RxPagingSource
import io.reactivex.Single
import toothpick.InjectConstructor

@InjectConstructor
internal class ${pagingSourceName}(
) : RxPagingSource<Int, ${modelName}>() {
    override fun loadSingle(params: LoadParams<Int>): Single<LoadResult<Int, ${modelName}>> {
        val page = params.key ?: 0
        val nextKey = page + 1
        val prevKey = if (page == 1) null else page - 1
        return TODO()
    }

    override fun getRefreshKey(state: PagingState<Int, ${modelName}>): Int? {
        val anchorPosition = state.anchorPosition ?: return null
        val page = state.closestPageToPosition(anchorPosition) ?: return null
        return page.prevKey?.plus(1) ?: page.nextKey?.minus(1)
    }
}


