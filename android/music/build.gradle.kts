plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

apply(from = "../common.gradle")

android {
    namespace = "com.wurengao.music"
}

dependencies{
    implementation(project(path=":common"))
    implementation("androidx.core:core-ktx:+")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
}