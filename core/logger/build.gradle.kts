plugins {
    id("town.millie.primitive.android.library")
    id("town.millie.primitive.android.kotlin")
    id("town.millie.primitive.android.hilt")
}

android.namespace = "town.millie.logger"
android.buildFeatures.resValues = false

dependencies {
    implementation(projects.core.contract)

    implementation(libs.timber)
}
