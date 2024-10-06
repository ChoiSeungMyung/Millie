plugins {
    id("town.millie.primitive.android.library")
    id("town.millie.primitive.android.kotlin")
    id("town.millie.primitive.android.hilt")
}

android.namespace = "town.millie.initializer"
android.buildFeatures.resValues = false

dependencies {
    implementation(libs.androidx.startup)

    implementation(libs.timber)
}
