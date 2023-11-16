plugins {
    id("com.android.library")
}

apply(from = "../common.gradle")

android {
    namespace = "com.wurengao.profile"
}

dependencies{
    implementation(project(path=":common"))
}