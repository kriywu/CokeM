plugins {
    id("com.android.application")
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
}
