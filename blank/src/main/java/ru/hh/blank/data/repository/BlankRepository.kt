package ru.hh.blank.data.repository

import androidx.paging.PagingData
import io.reactivex.Observable
import ru.hh.blank.data.model.BlankData
import ru.hh.blank.data.paging.BlankPager
import toothpick.InjectConstructor

@InjectConstructor
internal class BlankRepository(
    private val pager: BlankPager,
) {
    fun getBlankList(): Observable<PagingData<BlankData>> {
        return pager.getPager()
    }
}

