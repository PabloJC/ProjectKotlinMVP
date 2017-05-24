package com.mibaldi.proyectkotlin.application

/**
 * Created by mikelbalducieldiaz on 21/5/17.
 */
class App: android.app.Application() {

    val component: AppComponent by lazy {
        DaggerAppComponent
                .builder()
                .appModule(AppModule(this))
                .build()
    }
    override fun onCreate(){
        super.onCreate()
        component.inject(this)
    }
}