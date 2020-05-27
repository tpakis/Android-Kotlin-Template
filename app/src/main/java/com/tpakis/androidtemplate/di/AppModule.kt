package com.tpakis.androidtemplate.di

import android.content.Context
import com.tpakis.androidtemplate.App
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
}
