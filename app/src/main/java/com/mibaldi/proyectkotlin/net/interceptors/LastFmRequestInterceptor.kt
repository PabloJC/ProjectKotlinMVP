package com.mibaldi.proyectkotlin.net.interceptors

import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created by mikelbalducieldiaz on 24/5/17.
 */
class LastFmRequestInterceptor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        val url = request.url().newBuilder()

                .addQueryParameter("format", "json")
                .build()

        val newRequest = request.newBuilder()
                .url(url)
                .build()

        return chain.proceed(newRequest)
    }
}