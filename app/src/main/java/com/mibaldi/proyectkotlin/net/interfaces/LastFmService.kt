package com.mibaldi.proyectkotlin.net.interfaces

import com.mibaldi.proyectkotlin.data.models.Item
import com.mibaldi.proyectkotlin.data.models.Prefix
import com.mibaldi.proyectkotlin.data.models.PrefixList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by mikelbalducieldiaz on 24/5/17.
 */
interface LastFmService {

    /*@GET("/2.0/?method=artist.search")
    fun searchArtist(@Query("artist") artist: String): Call<Item>

    @GET("/2.0/?method=artist.getinfo")
    fun requestArtistInfo(@Query("mbid") id: String, @Query("lang") language: String): Call<Item>

    @GET("/2.0/?method=artist.gettopalbums")
    fun requestAlbums(@Query("mbid") id: String, @Query("artist") artist: String): Call<Item>

    @GET("/2.0/?method=artist.getsimilar")
    fun requestSimilar(@Query("mbid") id: String): Call<Item>

    @GET("/2.0/?method=album.getInfo")
    fun requestAlbum(@Query("mbid") id: String): Call<Item>*/

    @GET("/api/es/v1/Prefix")
    fun requestPrefixs():Call<PrefixList>
}


