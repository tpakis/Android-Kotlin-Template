plugins {
    `kotlin-dsl`
}

repositories {
    jcenter()
    google()
}
dependencies {
    implementation("com.android.tools.build:gradle:3.6.3")
}

kotlinDslPluginOptions {
    experimentalWarning.set(false)
}