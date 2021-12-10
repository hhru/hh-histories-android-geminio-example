package ${packageName}.network.converter

import ${packageName}.model.${modelName}
import ${packageName}.network.model.${networkModelName}
import toothpick.InjectConstructor

@InjectConstructor
internal class ${converterName} {

    fun convert(networkModel: ${networkModelName}): List<${modelName}> {
        return TODO()
    }

}
