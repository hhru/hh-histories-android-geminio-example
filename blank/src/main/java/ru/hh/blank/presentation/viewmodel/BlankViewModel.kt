package ru.hh.blank.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import ru.hh.blank.data.model.BlankData
import ru.hh.blank.feature.BlankFeature
import ru.hh.blank.feature.BlankFeature.Wish
import toothpick.InjectConstructor
import toothpick.ktp.delegate.inject
import javax.inject.Singleton

@Singleton
@InjectConstructor
internal class BlankViewModel : ViewModel() {

    private val feature: BlankFeature by inject()
    private val compositeDisposable = CompositeDisposable()

    fun loadData() = feature.accept(Wish.Load)

    fun observeUiState(renderState: (PagingData<BlankData>) -> Unit) = Observable.wrap(feature)
        .map(BlankFeature.State::data)
        .subscribe(renderState::invoke)
        .disposeOnCleared()

    override fun onCleared() {
        feature.dispose()
    }

    private fun Disposable.disposeOnCleared() {
        compositeDisposable.add(this)
    }
}
