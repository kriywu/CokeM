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
}