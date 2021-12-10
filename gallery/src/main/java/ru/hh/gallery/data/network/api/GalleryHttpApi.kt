package ru.hh.gallery.data.network.api

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query
import ru.hh.gallery.data.network.model.GalleryNetwork

internal interface GalleryHttpApi {

    @GET("/v1/curated")
    fun getGallery(
        @Query("page") page: Int,
        @Query("per_page") perPage: Int,
    ): Single<GalleryNetwork>

}
