package com.mibaldi.proyectkotlin.application

import com.mibaldi.proyectkotlin.ui.presenters.homeActivity.DetailComponent
import com.mibaldi.proyectkotlin.ui.presenters.homeActivity.DetailModule
import com.mibaldi.proyectkotlin.ui.presenters.homeActivity.HomeComponent
import com.mibaldi.proyectkotlin.ui.presenters.homeActivity.HomeModule

/**
 * Created by mikelbalducieldiaz on 21/5/17.
 */

@javax.inject.Singleton
@dagger.Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    fun inject(app: App)
    fun plus(homeModule: HomeModule): HomeComponent
    fun plus(detailModule: DetailModule): DetailComponent
}