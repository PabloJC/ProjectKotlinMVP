package com.mibaldi.proyectkotlin.ui.presenters.homeActivity

import com.mibaldi.proyectkotlin.ui.activities.MainActivity

/**
 * Created by mikelbalducieldiaz on 21/5/17.
 */
@javax.inject.Singleton
@dagger.Subcomponent(modules = arrayOf(HomeModule::class))
interface HomeComponent {
    fun inject(activity: MainActivity)
    fun inject(presenter: HomePresenter)
}