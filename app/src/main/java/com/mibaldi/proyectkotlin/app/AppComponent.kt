package com.mibaldi.proyectkotlin.app

/**
 * Created by mikelbalducieldiaz on 21/5/17.
 */

@javax.inject.Singleton
@dagger.Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    fun inject(app: App)
    fun plus(homeModule: com.mibaldi.proyectkotlin.home.HomeModule): com.mibaldi.proyectkotlin.home.HomeComponent
}