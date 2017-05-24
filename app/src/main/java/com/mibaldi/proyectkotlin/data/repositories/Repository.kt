package com.mibaldi.proyectkotlin.data.repositories

import com.mibaldi.proyectkotlin.data.models.Item

/**
 * Created by mikelbalducieldiaz on 21/5/17.
 */
class Repository {

    fun getListItems():List<Item>{
        return (1..10).map { Item(it.toLong(),"Title: $it","http://lorempixel.com/400/400/sports/$it") }
    }
}