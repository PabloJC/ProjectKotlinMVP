package com.mibaldi.proyectkotlin.home

import com.mibaldi.proyectkotlin.models.Item
import com.mibaldi.proyectkotlin.base.BaseMvpPresenter
import com.mibaldi.proyectkotlin.base.BaseMvpView

object RepositoriesContract {

    interface View : BaseMvpView {
        fun showOrganizations(items: List<Item>)
        fun showProgress()
    }

    interface Presenter : BaseMvpPresenter<View> {
        fun loadRepositories()

    }


}