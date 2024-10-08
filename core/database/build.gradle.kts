plugins {
    id("town.millie.primitive.android.library")
    id("town.millie.primitive.android.kotlin")
    id("town.millie.primitive.android.hilt")
}

android.namespace = "town.millie.core.database"
android.buildFeatures.resValues = false

dependencies {
    implementation(projects.core.model)

    implementation(libs.androidx.room)
    implementation(libs.androidx.room.ktx)
    ksp(libs.androidx.room.compiler)

    compileOnly(libs.protobuf.google)
}
