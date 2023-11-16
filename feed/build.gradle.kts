plugins {
    id("com.android.library")
}

apply(from = "../common.gradle")

android {
    namespace = "com.wurengao.feed"
}

dependencies{
    implementation(project(path=":common"))
}