package com.tpakis.androidtemplate

import android.app.Application
import android.content.Context
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ProcessLifecycleOwner
import com.tpakis.androidtemplate.di.AppComponent
import com.tpakis.androidtemplate.di.AppModule
import com.tpakis.androidtemplate.di.DaggerAppComponent
import com.tpakis.core.ApplicationLifecycleObserver
import timber.log.Timber

class App : Application(), LifecycleObserver {

    val component: AppComponent by lazy {
        DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        // to observe Application lifecycle events
        ProcessLifecycleOwner.get().lifecycle.addObserver(ApplicationLifecycleObserver)
        setupTimber()
    }

    private fun setupTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(
                object : Timber.DebugTree() {
                    override fun createStackElementTag(element: StackTraceElement): String? {
                        return String.format(
                            "[%s#%s:%s]",
                            super.createStackElementTag(element),
                            element.methodName,
                            element.lineNumber
                        )
                    }
                })
        }
    }
    companion object {
        fun getComponent(context: Context) =
            (context.applicationContext as? App)?.component
    }
}
