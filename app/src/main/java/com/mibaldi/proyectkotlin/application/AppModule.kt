package com.mibaldi.proyectkotlin.application

import com.mibaldi.proyectkotlin.BuildConfig
import com.mibaldi.proyectkotlin.data.repositories.Repository
import com.mibaldi.proyectkotlin.net.interceptors.LastFmRequestInterceptor
import com.mibaldi.proyectkotlin.net.interfaces.LastFmService
import com.mibaldi.proyectkotlin.router.Router
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by mikelbalducieldiaz on 21/5/17.
 */

@dagger.Module class AppModule(val app: App) {


    @dagger.Provides
    @javax.inject.Singleton
    fun provideApp() = app

    @dagger.Provides
    @javax.inject.Singleton
    fun provideRepository(lastFmService: LastFmService): Repository {
        val repo = Repository(lastFmService)
        return repo
    }

    @dagger.Provides
    @javax.inject.Singleton
    fun provideRouter(): Router {
        val router = Router(app.applicationContext)
        return router
    }

    @dagger.Provides
    @javax.inject.Singleton
    @javax.inject.Named("ApiManager")
    fun provideSomething(): String {
        return "apiManager"
    }

    @Provides @Singleton
    fun provideOkHttpClient(interceptor: LastFmRequestInterceptor): OkHttpClient =
            OkHttpClient().newBuilder()
                    .addInterceptor(interceptor)
                    .addInterceptor(HttpLoggingInterceptor().apply {
                        level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
                    })
                    .build()

    @Provides @Singleton
    fun provideRequestInterceptor()
            = LastFmRequestInterceptor()

    @Provides @Singleton
    fun provideRestAdapter(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .baseUrl("https://trasmeup-pre.trasmediterranea.es")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    @Provides @Singleton
    fun providesLastFmService(retrofit: Retrofit): LastFmService = retrofit.create(LastFmService::class.java)
}


