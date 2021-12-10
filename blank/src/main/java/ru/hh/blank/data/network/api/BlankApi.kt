package ru.hh.blank.data.network.api

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query
import ru.hh.blank.data.network.model.BlankNetwork

internal interface BlankApi {

    @GET("/v1/curated")
    fun getBlankList(
        @Query("page") page: Int,
        @Query("per_page") perPage: Int,
    ): Single<BlankNetwork>

}
