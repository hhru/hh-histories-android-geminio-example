package ru.hh.gallery.feature

import androidx.paging.PagingData
import com.badoo.mvicore.element.Actor
import com.badoo.mvicore.element.Reducer
import com.badoo.mvicore.feature.ActorReducerFeature
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.hh.gallery.data.model.GalleryModel
import ru.hh.gallery.data.repository.GalleryRepository
import ru.hh.gallery.feature.GalleryFeature.State
import ru.hh.gallery.feature.GalleryFeature.Effect
import ru.hh.gallery.feature.GalleryFeature.Wish
import toothpick.InjectConstructor

@InjectConstructor
internal class GalleryFeature(
    actor: ActorImpl
) : ActorReducerFeature<Wish, Effect, State, Nothing>(
    initialState = State(),
    actor = actor,
    reducer = ReducerImpl(),
) {

    data class State(
        val data: PagingData<GalleryModel> = PagingData.empty()
    )

    sealed class Wish {
        object Load : Wish()
    }

    sealed class Effect {
        data class LoadSuccess(val data: PagingData<GalleryModel>) : Effect()
        data class Error(val throwable: Throwable) : Effect()
    }

    @InjectConstructor
    class ActorImpl(
        private val galleryRepository: GalleryRepository,
    ) : Actor<State, Wish, Effect> {
        override fun invoke(state: State, wish: Wish): Observable<Effect> {
            return when (wish) {
                is Wish.Load -> {
                    galleryRepository.getGallery()
                        .map<Effect> { Effect.LoadSuccess(it) }
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .onErrorReturn(Effect::Error)
                }
            }
        }
    }

    class ReducerImpl : Reducer<State, Effect> {
        override fun invoke(state: State, effect: Effect): State {
            return when (effect) {
                is Effect.LoadSuccess -> state.copy(data = effect.data)
                is Effect.Error -> state.copy(data = PagingData.empty())
            }
        }
    }

}
