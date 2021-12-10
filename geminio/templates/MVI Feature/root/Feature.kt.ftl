package ${packageName}

import com.badoo.mvicore.element.Actor
import com.badoo.mvicore.element.Reducer
import com.badoo.mvicore.feature.ActorReducerFeature
import io.reactivex.Observable
import ${packageName}.${featureName}.State
import ${packageName}.${featureName}.Effect
import ${packageName}.${featureName}.Wish
import toothpick.InjectConstructor

@InjectConstructor
internal class ${featureName}(
    actor: ActorImpl
) : ActorReducerFeature<Wish, Effect, State, Nothing>(
    initialState = State(),
    actor = actor,
    reducer = ReducerImpl(),
) {

    data class State(
        val yourData: Any? = null
    )

    sealed class Wish {

    }

    sealed class Effect {

    }

    @InjectConstructor
    class ActorImpl(

    ) : Actor<State, Wish, Effect> {
        override fun invoke(state: State, wish: Wish): Observable<Effect> {
            return when(wish) {
                TODO() -> Observable.just(TODO())
            }
        }
    }

    class ReducerImpl : Reducer<State, Effect> {
        override fun invoke(state: State, effect: Effect): State {
            return when(effect) {
                TODO() -> state.copy()
            }
        }
    }

}
