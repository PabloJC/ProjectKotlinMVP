package com.mibaldi.proyectkotlin.ui.presenters.homeActivity

import android.util.Log
import com.mibaldi.proyectkotlin.utils.app
import com.mibaldi.proyectkotlin.base.BaseMvpPresenterImpl
import com.mibaldi.proyectkotlin.ui.views.DetailContract
import com.mibaldi.proyectkotlin.domain.interactors.HomeInteractor
import com.mibaldi.proyectkotlin.ui.activities.DetailActivity
import com.mibaldi.proyectkotlin.ui.activities.MainActivity
import javax.inject.Inject

/**
 * Created by mikelbalducieldiaz on 21/5/17.
 */
class DetailPresenter(context: DetailActivity): BaseMvpPresenterImpl<DetailContract.View>(), DetailContract.Presenter {

    val component by lazy { context.app.component.plus(DetailModule(context)) }

    override fun loadRepositories() {

    }


    fun init() {

    }
}