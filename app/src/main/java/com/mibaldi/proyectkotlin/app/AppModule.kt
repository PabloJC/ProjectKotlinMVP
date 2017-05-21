package com.mibaldi.proyectkotlin.app

import com.mibaldi.proyectkotlin.repositories.Repository
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

/**
 * Created by mikelbalducieldiaz on 21/5/17.
 */

@Module class AppModule(val app: App) {
    @Provides
    @Singleton
    fun provideApp() = app

    @Provides
    @Singleton
    fun provideRepository(): Repository {
        val repo = Repository()
        return repo
    }

    @Provides
    @Singleton
    @Named("ApiManager")
    fun provideSomething(): String {
        return "apiManager"
    }
}


