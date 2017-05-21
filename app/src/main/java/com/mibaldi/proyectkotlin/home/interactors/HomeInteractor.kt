package com.mibaldi.proyectkotlin.home.interactors

import com.mibaldi.proyectkotlin.models.Item
import com.mibaldi.proyectkotlin.repositories.Repository

/**
 * Created by mikelbalducieldiaz on 21/5/17.
 */
interface HomeInteractor {


    fun getCurrentItem() : Item
    fun getListItems(): List<Item>
}