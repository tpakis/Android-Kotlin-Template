plugins {
    `kotlin-dsl`
}

repositories {
    jcenter()
    google()
}
dependencies {
    implementation("com.android.tools.build:gradle:3.6.3")
    implementation(kotlin("gradle-plugin", "1.3.71"))
}

kotlinDslPluginOptions {
    experimentalWarning.set(false)
}