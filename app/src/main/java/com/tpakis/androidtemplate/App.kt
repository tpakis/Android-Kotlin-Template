package com.tpakis.androidtemplate

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.*
import com.tpakis.core.ApplicationLifecycleObserver
import timber.log.Timber

class App : Application(), LifecycleObserver {
    val context: Context
        get() = applicationContext

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


}
