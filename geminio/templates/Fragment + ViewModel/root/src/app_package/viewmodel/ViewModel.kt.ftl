package ${packageName}.viewmodel

import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import toothpick.InjectConstructor
import toothpick.ktp.delegate.inject
import javax.inject.Singleton

@Singleton
@InjectConstructor
internal class ${viewModelName} : ViewModel() {

<#if useFeature == true>
    private val feature: ${featureName} by inject()
    private val compositeDisposable = CompositeDisposable()

    fun loadData() = TODO()

    fun observeUiState(renderState: () -> Unit) = TODO()

    override fun onCleared() {
        feature.dispose()
    }

    private fun Disposable.disposeOnCleared() {
        compositeDisposable.add(this)
    }
</#if>
}
