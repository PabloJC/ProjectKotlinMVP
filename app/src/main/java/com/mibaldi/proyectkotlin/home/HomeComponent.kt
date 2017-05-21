package com.mibaldi.proyectkotlin.home

import dagger.Subcomponent
import javax.inject.Singleton

/**
 * Created by mikelbalducieldiaz on 21/5/17.
 */
@Singleton
@Subcomponent (modules = arrayOf(HomeModule::class))
interface HomeComponent {
    fun inject(activity: MainActivity)
    fun inject(presenter: HomePresenter)
}