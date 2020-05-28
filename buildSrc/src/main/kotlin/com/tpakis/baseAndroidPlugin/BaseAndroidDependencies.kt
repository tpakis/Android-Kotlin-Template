package com.tpakis.baseAndroidPlugin

import org.gradle.api.Project
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.dependencies

fun DependencyHandler.addImplementation(source: String) {
    add("implementation", source)
}

fun DependencyHandler.addTestImplementation(source: String) {
    add("testImplementation", source)
}

fun DependencyHandler.addAndroidTestImplementation(source: String) {
    add("androidTestImplementation", source)
}

fun DependencyHandler.kapt(source: String) {
    add("kapt", source)
}

internal fun Project.configureDependencies() = dependencies {
    addImplementation(Libraries.kotlinStdLib)
    addImplementation(Libraries.appCompat)
    addImplementation(Libraries.ktxCore)
    addImplementation(Libraries.timber)
    addImplementation(Libraries.dagger)
    kapt(Libraries.daggerCompiler)

    addTestImplementation (TestLibraries.junit4)
    addAndroidTestImplementation (TestLibraries.testExt)
}