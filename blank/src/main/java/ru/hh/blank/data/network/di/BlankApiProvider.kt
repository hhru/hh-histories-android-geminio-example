package ru.hh.blank.data.network.di

import ru.hh.blank.data.network.api.BlankApi
import ru.hh.core.network.ApiFactory
import toothpick.InjectConstructor
import javax.inject.Provider

@InjectConstructor
internal class BlankApiProvider : Provider<BlankApi> {
    override fun get() = ApiFactory.createApi(BlankApi::class.java)
}
