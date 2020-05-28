package com.tpakis.baseAndroidPlugin

import org.gradle.api.Plugin
import org.gradle.api.Project

open class BaseAndroidPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.configureAndroid()
        project.configureDependencies()
    }
}