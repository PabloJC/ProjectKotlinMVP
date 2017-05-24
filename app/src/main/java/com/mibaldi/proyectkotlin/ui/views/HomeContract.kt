package com.mibaldi.proyectkotlin.ui.views

import com.mibaldi.proyectkotlin.data.models.Item
import com.mibaldi.proyectkotlin.base.BaseMvpPresenter
import com.mibaldi.proyectkotlin.base.BaseMvpView

object HomeContract {

    interface View : BaseMvpView {
        fun showOrganizations(items: List<Item>)
        fun showProgress()
    }

    interface Presenter : BaseMvpPresenter<View> {
        fun init()
        fun loadRepositories()
        fun goToDetail(id: Long)

    }


}