plugins {
    id("town.millie.primitive.android.library")
    id("town.millie.primitive.android.kotlin")
    id("town.millie.primitive.android.hilt")
}

android.namespace = "town.millie.core.domain"
android.buildFeatures.resValues = false

dependencies {
    implementation(projects.core.model)
    implementation(projects.core.data)
    implementation(libs.androidx.paging)
}
