package ru.hh.blank.data.network.di

import ru.hh.blank.data.network.api.BlankApi
import ru.hh.blank.data.repository.BlankRepository
import toothpick.config.Module
import toothpick.ktp.binding.bind

internal class BlankRemoteModule : Module() {
    init {
        bind<BlankApi>().toProvider(BlankApiProvider::class).singleton()
        bind<BlankRepository>().singleton()
    }
}
