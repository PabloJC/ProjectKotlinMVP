package com.mibaldi.proyectkotlin.ui.presenters.homeActivity

import com.mibaldi.proyectkotlin.ui.activities.DetailActivity

/**
 * Created by mikelbalducieldiaz on 21/5/17.
 */
@javax.inject.Singleton
@dagger.Subcomponent(modules = arrayOf(DetailModule::class))
interface DetailComponent {
    fun inject(activity: DetailActivity)
    fun inject(presenter: DetailPresenter)
}