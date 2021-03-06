import com.android.build.gradle.LibraryExtension
import org.gradle.api.Project
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.DependencyHandlerScope
import org.gradle.kotlin.dsl.apply

const val kotlinVersion = "1.3.71"

object BuildPlugins {

    object Versions {
        const val buildToolsVersion = "3.6.3"
        const val kotlinterVersion = "2.3.2"
    }

    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.buildToolsVersion}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
    const val androidApplication = "com.android.application"
    const val androidLibrary = "com.android.library"
    const val kotlinAndroid = "kotlin-android"
    const val kotlinter = "org.jmailen.kotlinter"
    const val kapt = "kotlin-kapt"
    const val kotlinAndroidExtensions = "kotlin-android-extensions"
    const val kotlinterGradlePlugin =
        "org.jmailen.gradle:kotlinter-gradle:${Versions.kotlinterVersion}"
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
        const val timber = "4.7.1"
        const val leakCanary = "2.3"
        const val daggerVersion = "2.27"
        const val material = "1.1.0"
    }

    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val processLifecycle = "androidx.lifecycle:lifecycle-process:${Versions.ktxLifecycle}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val ktxCore = "androidx.core:core-ktx:${Versions.ktx}"
    const val ktxLifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.ktxLifecycle}"
    const val ktxFragment = "androidx.fragment:fragment-ktx:${Versions.ktxFragment}"
    const val ktxLiveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.ktxLiveData}"
    const val ktxViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.ktxViewModel}"
    const val ktxNavRuntime = "androidx.navigation:navigation-runtime-ktx:${Versions.ktxNav}"
    const val ktxNavUi = "androidx.navigation:navigation-ui-ktx:${Versions.ktxNav}"
    const val ktvNavFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.ktxNav}"
    const val coroutinesCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutinesVersion}"
    const val coroutinesAnd =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutinesVersion}"
    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"
    const val leakCanary = "com.squareup.leakcanary:leakcanary-android:${Versions.leakCanary}"
    const val dagger = "com.google.dagger:dagger:${Versions.daggerVersion}"
    const val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.daggerVersion}"
    const val material = "com.google.android.material:material:${Versions.material}"
}

object TestLibraries {
    private object Versions {
        const val junit4 = "4.12"
        const val testExt = "1.1.1"
        const val espresso = "3.2.0"
        const val coroutines = "1.3.7"
    }

    const val junit4 = "junit:junit:${Versions.junit4}"
    const val testExt = "androidx.test.ext:junit:${Versions.testExt}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    const val coroutinesTest =
        "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"
}

object Modules {
    const val core = ":core"
}

fun DependencyHandler.kapt(source: String) {
    add("kapt", source)
}

fun Project.androidBasePlugins() {
    apply(plugin = BuildPlugins.kotlinAndroid)
    apply(plugin = BuildPlugins.kotlinAndroidExtensions)
    apply(plugin = BuildPlugins.kotlinter)
    apply(plugin = BuildPlugins.kapt)
}

fun DependencyHandlerScope.androidLibBaseDependencies() {
    "implementation"(Libraries.appCompat)
    "implementation"(Libraries.kotlinStdLib)
    "implementation"(Libraries.constraintLayout)
    "testImplementation"(TestLibraries.junit4)
    "testImplementation"(TestLibraries.testExt)
    "testImplementation"(TestLibraries.coroutinesTest)
    "androidTestImplementation"(TestLibraries.espresso)
}

fun LibraryExtension.androidLibBaseConfig() {
    compileSdkVersion(AndroidSdk.compileVersion)

    defaultConfig {
        minSdkVersion(AndroidSdk.minVersion)
        targetSdkVersion(AndroidSdk.targetVersion)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"

    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}
