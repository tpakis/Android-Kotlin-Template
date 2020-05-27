package com.tpakis.androidtemplate.di

import com.tpakis.androidtemplate.App
import com.tpakis.androidtemplate.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        ViewModelsModule::class
    ]
)

interface AppComponent {
    val app: App

    fun inject(app: App)
    fun inject(mainActivity: MainActivity)
}
