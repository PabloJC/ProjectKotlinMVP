package com.mibaldi.proyectkotlin.domain.interactors

import com.mibaldi.proyectkotlin.data.models.Item

/**
 * Created by mikelbalducieldiaz on 21/5/17.
 */
interface HomeInteractor {


    fun getCurrentItem() : Item
    fun getListItems(): List<Item>
}