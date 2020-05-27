
const val kotlinVersion = "1.3.71"

object BuildPlugins {

    object Versions {
        const val buildToolsVersion = "3.6.3"
    }

    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.buildToolsVersion}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
    const val androidApplication = "com.android.application"
    const val kotlinAndroid = "kotlin-android"
    const val kotlinAndroidExtensions = "kotlin-android-extensions"

}

object AndroidSdk {
    const val minVersion = 23
    const val compileVersion = 29
    const val targetVersion = compileVersion
}

object Libraries {
    private object Versions {
        const val appCompat = "1.1.0"
        const val constraintLayout = "1.1.3"
        const val ktx = "1.2.0"
        const val coroutinesVersion = "1.3.7"
        const val ktxLifecycle = "2.2.0"
        const val ktxFragment = "1.2.4"
        const val ktxLiveData = "2.2.0"
        const val ktxViewModel = "2.2.0"
        const val ktxNav = "2.3.0-beta01"
    }

    const val kotlinStdLib     = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion"
    const val appCompat        = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val ktxCore          = "androidx.core:core-ktx:${Versions.ktx}"
    const val ktxLifecycle     = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.ktxLifecycle}"
    const val ktxFragment      = "androidx.fragment:fragment-ktx:${Versions.ktxFragment}"
    const val ktxLiveData      = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.ktxLiveData}"
    const val ktxViewModel     = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.ktxViewModel}"
    const val ktxNavRuntime    = "androidx.navigation:navigation-runtime-ktx:${Versions.ktxNav}"
    const val ktxNavUi         = "androidx.navigation:navigation-ui-ktx:${Versions.ktxNav}"
    const val ktvNavFragment   = "androidx.navigation:navigation-fragment-ktx:${Versions.ktxNav}"
    const val coroutinesCore   = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutinesVersion}"
    const val coroutinesAnd    = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutinesVersion}"

}

object TestLibraries {
    private object Versions {
        const val junit4 = "4.12"
        const val testExt = "1.1.1"
        const val espresso = "3.2.0"
        const val coroutines = "1.3.7"
    }
    const val junit4           = "junit:junit:${Versions.junit4}"
    const val testExt          = "androidx.test.ext:junit:${Versions.testExt}"
    const val espresso         = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    const val coroutinesTest   = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"
}