package ${packageName}.network.di

import ${packageName}.network.api.${networkApiName}
import ${packageName}.repository.${repositoryName}
import toothpick.config.Module
import toothpick.ktp.binding.bind


internal class ${moduleName} : Module() {

    init {
        bind<${networkApiName}>().toProvider(${apiProviderName}::class).singleton()
        bind<${repositoryName}>().singleton()
    }

}
