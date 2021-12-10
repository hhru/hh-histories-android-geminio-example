package ${packageName}.repository

import io.reactivex.Observable
import toothpick.InjectConstructor

@InjectConstructor
internal class ${repositoryName}(
) {

    fun get${entityPrefix}() : Observable<Any> = TODO()

}
