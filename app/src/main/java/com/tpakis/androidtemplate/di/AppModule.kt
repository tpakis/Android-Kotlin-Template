package com.tpakis.androidtemplate.di

import android.content.Context
import com.tpakis.androidtemplate.App
import com.tpakis.androidtemplate.BuildConfig
import com.tpakis.core.annotations.ApiUrl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(
    @get:Provides
    @get:Singleton
    val app: App
) {

    val applicationContext: Context
        @Provides
        @Singleton
        get() = app

    @Provides
    @ApiUrl
    fun provideApiUrl(): String {
        if (BuildConfig.DEBUG) {
            return BuildConfig.DEBUG_URL
        }
        return BuildConfig.RELEASE_URL
    }
}
