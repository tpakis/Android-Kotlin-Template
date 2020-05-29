
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
    implementation(Libraries.timber)
    implementation(Libraries.dagger)
    kapt(Libraries.daggerCompiler)
}