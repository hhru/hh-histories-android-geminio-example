package ru.hh.gallery.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import ru.hh.gallery.data.model.GalleryModel
import ru.hh.gallery.feature.GalleryFeature
import toothpick.InjectConstructor
import toothpick.ktp.delegate.inject
import javax.inject.Singleton

@Singleton
@InjectConstructor
internal class GalleryViewModel : ViewModel() {

    private val feature: GalleryFeature by inject()
    private val compositeDisposable = CompositeDisposable()

    fun loadData() = feature.accept(GalleryFeature.Wish.Load)

    fun observeUiState(renderState: (PagingData<GalleryModel>) -> Unit) = Observable.wrap(feature)
        .map(GalleryFeature.State::data)
        .subscribe(renderState::invoke)
        .disposeOnCleared()

    override fun onCleared() {
        feature.dispose()
    }

    private fun Disposable.disposeOnCleared() {
        compositeDisposable.add(this)
    }
}
