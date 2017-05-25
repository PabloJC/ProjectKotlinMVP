package com.mibaldi.proyectkotlin.ui.presenters.homeActivity

import com.mibaldi.proyectkotlin.data.repositories.Repository
import com.mibaldi.proyectkotlin.domain.interactors.HomeInteractor
import com.mibaldi.proyectkotlin.domain.interactors.HomeInteractorImpl
import com.mibaldi.proyectkotlin.ui.activities.MainActivity
import dagger.Module
import dagger.Provides

/**
 * Created by mikelbalducieldiaz on 21/5/17.
 */
@Module
class HomeModule(val activity: MainActivity) {

    @Provides
    fun provideRepository(repository: Repository): HomeInteractor {
        val interactor = HomeInteractorImpl(repository)
        return interactor
    }
}