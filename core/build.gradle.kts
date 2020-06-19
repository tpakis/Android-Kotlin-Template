
plugins {
    id(BuildPlugins.androidLibrary)
}
androidBasePlugins()

android {
    androidLibBaseConfig()
}

dependencies {
    androidLibBaseDependencies()
    implementation(Libraries.ktxViewModel)
    implementation(Libraries.ktxLifecycle)
    implementation(Libraries.material)
    implementation(Libraries.timber)
    implementation(Libraries.dagger)
    implementation(Libraries.gson)
    kapt(Libraries.daggerCompiler)
}