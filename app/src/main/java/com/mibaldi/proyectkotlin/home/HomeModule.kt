package com.mibaldi.proyectkotlin.home

import com.mibaldi.proyectkotlin.home.interactors.HomeInteractor
import com.mibaldi.proyectkotlin.home.interactors.HomeInteractorImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by mikelbalducieldiaz on 21/5/17.
 */
@Module
class HomeModule(val activity: MainActivity) {

    @Provides
    fun provideRepository(): HomeInteractor {
        val interactor = HomeInteractorImpl(activity.repository)
        return interactor
    }
}