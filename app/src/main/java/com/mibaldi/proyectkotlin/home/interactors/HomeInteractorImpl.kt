package com.mibaldi.proyectkotlin.home.interactors

import com.mibaldi.proyectkotlin.models.Item
import com.mibaldi.proyectkotlin.repositories.Repository

/**
 * Created by mikelbalducieldiaz on 21/5/17.
 */
class HomeInteractorImpl(val repository: Repository) : HomeInteractor {
    override fun getListItems(): List<Item> {
       return repository.getListItems()
    }

    override fun getCurrentItem(): Item {
        return repository.getListItems().first()
    }
}