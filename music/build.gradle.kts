plugins {
    id("com.android.library")
}

apply(from = "../common.gradle")

android {
    namespace = "com.wurengao.music"
}

dependencies{
    implementation(project(path=":common"))
}