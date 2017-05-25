package com.mibaldi.proyectkotlin.ui.presenters.homeActivity

import android.util.Log
import com.mibaldi.proyectkotlin.utils.app
import com.mibaldi.proyectkotlin.base.BaseMvpPresenterImpl
import com.mibaldi.proyectkotlin.ui.views.HomeContract
import com.mibaldi.proyectkotlin.domain.interactors.HomeInteractor
import com.mibaldi.proyectkotlin.router.Router
import com.mibaldi.proyectkotlin.ui.activities.MainActivity
import javax.inject.Inject

/**
 * Created by mikelbalducieldiaz on 21/5/17.
 */
class HomePresenter(context: MainActivity): BaseMvpPresenterImpl<HomeContract.View>(), HomeContract.Presenter {

    @Inject
    lateinit var interactor: HomeInteractor


    @Inject
    lateinit var router: Router

    val component by lazy { context.app.component.plus(HomeModule(context)) }

    override fun loadRepositories() {
        val items = interactor.getListItems()
        mView?.showProgress()
        mView?.showOrganizations(items)
    }


    override fun init() {
        component.inject(this)

        interactor.getPrefixs()
        val currentItem = interactor.getCurrentItem()
        Log.d("PRESENTER",currentItem.toString())
    }

    override fun goToDetail(id: Long) {
        router.goToDetailActivity(id)
    }
}