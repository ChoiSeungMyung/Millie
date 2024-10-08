import town.millie.ktx.implementation

plugins {
    id("town.millie.primitive.android.library")
    id("town.millie.primitive.android.kotlin")
    id("town.millie.primitive.android.hilt")
}

android.namespace = "town.millie.core.data"
android.buildFeatures.resValues = false

dependencies {
    implementation(projects.core.model)
    implementation(projects.core.database)
    implementation(projects.core.network)
    implementation(libs.androidx.paging)
    implementation(libs.retrofit)

    implementation(libs.androidx.room)
    implementation(libs.androidx.room.ktx)
}
