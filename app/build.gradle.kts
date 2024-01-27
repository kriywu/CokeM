plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}
apply(from= "../common.gradle")


android {
    namespace = "com.wurengao.mycloudmusic"

    defaultConfig {
        applicationId = "com.wurengao.mycloudmusic"
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
    }

    viewBinding {
        enable = true
    }
}
dependencies {
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    implementation(project(path=":common"))
    implementation(project(mapOf("path" to ":feed")))
    implementation(project(mapOf("path" to ":music")))
    implementation(project(mapOf("path" to ":profile")))
    implementation("androidx.core:core-ktx:+")
}
