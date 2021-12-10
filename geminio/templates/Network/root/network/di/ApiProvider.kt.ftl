package ${packageName}.network.di

import ru.hh.core.network.ApiFactory
import ${packageName}.network.api.${networkApiName}
import toothpick.InjectConstructor
import javax.inject.Provider

@InjectConstructor
internal class ${apiProviderName} : Provider<${networkApiName}> {

    override fun get() = ApiFactory.createApi(${networkApiName}::class.java)

}
