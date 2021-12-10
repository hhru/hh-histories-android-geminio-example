package ru.hh.blank.feature.di

import ru.hh.blank.feature.BlankFeature
import toothpick.config.Module
import toothpick.ktp.binding.bind

class BlankFeatureModule : Module() {

    init {
        bind<BlankFeature>().singleton()
    }

}
