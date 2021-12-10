package ${packageName}.di

import ${packageName}.${featureName}
import toothpick.config.Module
import toothpick.ktp.binding.bind


internal class ${moduleName} : Module() {

    init {
        bind<${featureName}>().singleton()
    }

}
