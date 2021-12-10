package ru.hh.blank.feature

import androidx.paging.PagingData
import com.badoo.mvicore.element.Actor
import com.badoo.mvicore.element.Reducer
import com.badoo.mvicore.feature.ActorReducerFeature
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.hh.blank.data.model.BlankData
import ru.hh.blank.data.repository.BlankRepository
import ru.hh.blank.feature.BlankFeature.*
import toothpick.InjectConstructor

@InjectConstructor
internal class BlankFeature(
    actor: ActorImpl,
) : ActorReducerFeature<Wish, Effect, State, Nothing>(
    initialState = State(),
    actor = actor,
    reducer = ReducerImpl(),
) {
    data class State(
        val data: PagingData<BlankData> = PagingData.empty(),
    )

    sealed class Wish {
        object Load : Wish()
    }

    sealed class Effect {
        data class LoadSuccess(val data: PagingData<BlankData>) : Effect()
        data class Error(val throwable: Throwable) : Effect()
        object Loading : Effect()
    }

    @InjectConstructor
    class ActorImpl(
        private val blankRepository: BlankRepository,
    ) : Actor<State, Wish, Effect> {
        override fun invoke(state: State, wish: Wish): Observable<Effect> = when (wish) {
            is Wish.Load -> {
                blankRepository.getBlankList()
                    .map<Effect> { Effect.LoadSuccess(it) }
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .startWith(Effect.Loading)
                    .onErrorReturn(Effect::Error)
            }
        }
    }

    class ReducerImpl : Reducer<State, Effect> {
        override fun invoke(state: State, effect: Effect): State =
            when (effect) {
                is Effect.LoadSuccess -> state.copy(data = effect.data)
                is Effect.Error -> state.copy(data = PagingData.empty())
                is Effect.Loading -> state.copy(data = PagingData.empty())
            }
    }
}
