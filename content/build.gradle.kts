
plugins {
    id(BuildPlugins.androidLibrary)
}
androidBasePlugins()

android {
    androidLibBaseConfig()
}

dependencies {
    androidLibBaseDependencies()
    implementation(Libraries.timber)
    implementation(Libraries.dagger)
    implementation(Libraries.stethoOkHttp)
    implementation(Libraries.gson)
    kapt(Libraries.daggerCompiler)
    retrofit()

    implementation(project(Modules.core))
}