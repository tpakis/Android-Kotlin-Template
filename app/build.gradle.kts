plugins {
    id(BuildPlugins.androidApplication)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.kotlinAndroidExtensions)
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

}

dependencies {
    implementation(Libraries.kotlinStdLib)
    implementation(Libraries.appCompat)
    implementation(Libraries.ktxCore)
    implementation(Libraries.constraintLayout)
    implementation(Libraries.coroutinesAnd)
    implementation(Libraries.coroutinesCore)

    testImplementation (TestLibraries.junit4)
    testImplementation (TestLibraries.coroutinesTest)
    androidTestImplementation (TestLibraries.testExt)
    androidTestImplementation (TestLibraries.espresso)
    androidTestImplementation(TestLibraries.coroutinesTest)

}
