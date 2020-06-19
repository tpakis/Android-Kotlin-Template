
plugins {
    id(BuildPlugins.androidApplication)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.kotlinAndroidExtensions)
    id(BuildPlugins.kotlinter)
    id(BuildPlugins.kapt)
    id(BuildPlugins.safeNavArgs)
}
android {
    compileSdkVersion(AndroidSdk.compileVersion)

    defaultConfig {
        applicationId = "com.tpakis.androidtemplate"
        minSdkVersion(AndroidSdk.minVersion)
        targetSdkVersion(AndroidSdk.targetVersion)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        buildConfigField ("String", "RELEASE_URL", "\"https://travelers-api.getyourguide.com/\"")
        // should be the debug url
        buildConfigField ("String", "DEBUG_URL", "\"https://travelers-api.getyourguide.com/\"")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
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
    testOptions {
        animationsDisabled = true
        unitTests.apply {
            isIncludeAndroidResources = true
        }
    }
    packagingOptions {
        exclude("META-INF/AL2.0")
        exclude("META-INF/LGPL2.1")
    }
    sourceSets.getByName("androidTest") {
        java.srcDir("src/androidTest/java")
        java.srcDir("src/sharedTest/java")
    }
    sourceSets.getByName("test") {
        java.srcDir("src/test/java")
        java.srcDir("src/sharedTest/java")
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
    implementation(Libraries.stetho)
    implementation(Libraries.stethoOkHttp)
    implementation(Libraries.picasso)
    implementation(Libraries.okhttp)
    implementation(Libraries.picassoTransformations)
    kapt(Libraries.daggerCompiler)
    debugImplementation(Libraries.leakCanary)

    implementation(project(Modules.core))
    implementation(project(Modules.content))

    testImplementation(TestLibraries.junit4)
    testImplementation(TestLibraries.testExt)
    testImplementation(TestLibraries.coroutinesTest)
    testImplementation(TestLibraries.archCoreTest)
    testImplementation(TestLibraries.roboelectric)
    testImplementation(TestLibraries.mockk)
    testImplementation(TestLibraries.testCore)
    androidTestImplementation(TestLibraries.mockkAndroid)
    androidTestImplementation(TestLibraries.testExt)
    androidTestImplementation(TestLibraries.espresso)
    androidTestImplementation(TestLibraries.espressoContrib)
    androidTestImplementation(TestLibraries.coroutinesTest)
    androidTestImplementation(TestLibraries.mockWebServer)
    androidTestImplementation(TestLibraries.mockito)
    androidTestImplementation(TestLibraries.mockitoDexMaker)
    // Testing code should not be included in the main code. Should be androidTestImplementation not implementation.
    //  Once https://issuetracker.google.com/128612536 is fixed this can be fixed.
    implementation(TestLibraries.fragmentTesting)
    implementation(TestLibraries.testCore)
}
