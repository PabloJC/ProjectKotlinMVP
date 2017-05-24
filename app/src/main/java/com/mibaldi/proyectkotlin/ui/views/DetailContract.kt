package com.mibaldi.proyectkotlin.ui.views

import com.mibaldi.proyectkotlin.data.models.Item
import com.mibaldi.proyectkotlin.base.BaseMvpPresenter
import com.mibaldi.proyectkotlin.base.BaseMvpView

object DetailContract {

    interface View : BaseMvpView {
        fun showOrganizations(items: List<Item>)
        fun showProgress()
    }

    interface Presenter : BaseMvpPresenter<View> {
        fun loadRepositories()

    }


}