package com.mibaldi.proyectkotlin.domain.interactors

import com.mibaldi.proyectkotlin.data.models.Item
import com.mibaldi.proyectkotlin.data.models.Prefix

/**
 * Created by mikelbalducieldiaz on 21/5/17.
 */
interface HomeInteractor {


    fun getCurrentItem() : Item
    fun getListItems(): List<Item>
    fun getPrefixs()
}