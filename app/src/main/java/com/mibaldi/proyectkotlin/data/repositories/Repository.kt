package com.mibaldi.proyectkotlin.data.repositories

import android.os.AsyncTask
import com.mibaldi.proyectkotlin.data.models.Item
import com.mibaldi.proyectkotlin.data.models.Prefix
import com.mibaldi.proyectkotlin.net.interfaces.LastFmService
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Response
import org.jetbrains.anko.doAsyncResult
import java.io.IOException

/**
 * Created by mikelbalducieldiaz on 21/5/17.
 */
class Repository(val lastFmService: LastFmService) {

    fun getListItems(): List<Item> {
        return (1..10).map { Item(it.toLong(), "Title: $it", "http://lorempixel.com/400/400/sports/$it") }
    }

    fun requestPrefixs() {
        doAsyncResult {
            val call = lastFmService.requestPrefixs()
            val result = call.execute().body()
        }

        //val albums = AlbumMapper().transform(result.topAlbums.albums)
    }
}