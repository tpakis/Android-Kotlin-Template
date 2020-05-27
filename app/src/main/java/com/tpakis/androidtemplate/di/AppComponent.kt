package com.tpakis.androidtemplate.di

import com.tpakis.androidtemplate.App
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class
    ]
)


interface AppComponent {
    val app: App

    fun inject(app: App)
}