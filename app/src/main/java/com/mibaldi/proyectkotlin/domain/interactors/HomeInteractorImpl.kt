package com.mibaldi.proyectkotlin.domain.interactors

import com.mibaldi.proyectkotlin.data.models.Item
import com.mibaldi.proyectkotlin.data.models.Prefix
import com.mibaldi.proyectkotlin.data.repositories.Repository

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
    override fun getPrefixs() {
        repository.requestPrefixs()
    }
}