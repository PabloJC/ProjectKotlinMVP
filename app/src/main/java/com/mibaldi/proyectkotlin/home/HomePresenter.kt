package com.mibaldi.proyectkotlin.home

import android.content.Context
import android.util.Log
import com.mibaldi.proyectkotlin.app
import com.mibaldi.proyectkotlin.base.BaseMvpPresenterImpl
import com.mibaldi.proyectkotlin.home.interactors.HomeInteractor
import com.mibaldi.proyectkotlin.models.Item
import com.mibaldi.proyectkotlin.models.getItems
import com.mibaldi.proyectkotlin.repositories.Repository
import javax.inject.Inject

/**
 * Created by mikelbalducieldiaz on 21/5/17.
 */
class HomePresenter(context: MainActivity): BaseMvpPresenterImpl<RepositoriesContract.View>(), RepositoriesContract.Presenter {

    @Inject
    lateinit var interactor: HomeInteractor

    val component by lazy { context.app.component.plus(HomeModule(context)) }

    override fun loadRepositories() {
        val items = interactor.getListItems()
        mView?.showProgress()
        mView?.showOrganizations(items)
    }


    fun init() {
        component.inject(this)
        val currentItem = interactor.getCurrentItem()
        Log.d("PRESENTER",currentItem.toString())
    }
}