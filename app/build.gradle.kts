
plugins {
    id(BuildPlugins.androidApplication)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.kotlinAndroidExtensions)
    id(BuildPlugins.kotlinter)
    id(BuildPlugins.kapt)
}
android {
    compileSdkVersion(AndroidSdk.compileVersion)

    defaultConfig {
        applicationId = "com.tpakis.androidtemplate"
        minSdkVersion(AndroidSdk.minVersion)
        targetSdkVersion(AndroidSdk.targetVersion)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

androidExtensions {
    isExperimental = true
}

dependencies {
    implementation(Libraries.kotlinStdLib)
    implementation(Libraries.appCompat)
    implementation(Libraries.ktxCore)
    implementation(Libraries.constraintLayout)
    implementation(Libraries.coroutinesAnd)
    implementation(Libraries.coroutinesCore)
    implementation(Libraries.ktxFragment)
    implementation(Libraries.ktxLifecycle)
    implementation(Libraries.ktxLiveData)
    implementation(Libraries.ktxNavRuntime)
    implementation(Libraries.ktxNavUi)
    implementation(Libraries.ktxViewModel)
    implementation(Libraries.ktvNavFragment)
    implementation(Libraries.processLifecycle)
    implementation(Libraries.timber)
    implementation(Libraries.dagger)
    kapt(Libraries.daggerCompiler)
    debugImplementation(Libraries.leakCanary)

    implementation(project(Modules.core))
    
    testImplementation (TestLibraries.junit4)
    testImplementation (TestLibraries.coroutinesTest)
    androidTestImplementation (TestLibraries.testExt)
    androidTestImplementation (TestLibraries.espresso)
    androidTestImplementation(TestLibraries.coroutinesTest)

}
