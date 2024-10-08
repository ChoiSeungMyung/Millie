plugins {
    id("town.millie.primitive.android.library")
    id("town.millie.primitive.android.kotlin")
    id("town.millie.primitive.android.kotlin.serialization")
    id("town.millie.primitive.android.hilt")
}

android {
    namespace = "town.millie.core.network"
    buildFeatures {
        resValues = false
    }
}

dependencies {
    implementation(projects.core.contract)
    implementation(projects.core.model)

    implementation(platform(libs.okhttp.bom))
    implementation(libs.okhttp)
    implementation(libs.okhttp.logging.interceptor)

    implementation(libs.retrofit)
    implementation(libs.retrofit.converter.serialization)

    implementation(libs.timber)
}
