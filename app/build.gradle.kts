@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("town.millie.primitive.android.application")
    id("town.millie.primitive.android.kotlin")
    id("town.millie.primitive.android.kotlin.serialization")
    id("town.millie.primitive.android.kotlin.parcelize")
    id("town.millie.primitive.android.hilt")
    id("town.millie.primitive.android.compose")
    id("town.millie.primitive.android.unitTest")
}

android {
    namespace = "town.millie"

    buildFeatures {
        resValues = true
    }
}

dependencies {
    implementation(projects.core.contract)
    implementation(projects.core.model)
    implementation(projects.core.data)
    implementation(projects.core.network)
    implementation(projects.core.domain)
    implementation(projects.presentation)

    implementation(libs.google.material)
}
