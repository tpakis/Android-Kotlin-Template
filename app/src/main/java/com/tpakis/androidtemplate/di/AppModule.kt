package com.tpakis.androidtemplate.di

import android.content.Context
import com.tpakis.androidtemplate.App
import com.tpakis.androidtemplate.BuildConfig
import com.tpakis.core.annotations.ApiUrl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
open class AppModule(
    private val applicationContext: Context
) {

    @Provides
    @Singleton
    fun provideApplicationContext(): Context {
        return applicationContext
    }

    @Provides
    @ApiUrl
    fun provideApiUrl(): String {
        if (BuildConfig.DEBUG) {
            return BuildConfig.DEBUG_URL
        }
        return BuildConfig.RELEASE_URL
    }
}
