import town.millie.ktx.implementation

plugins {
    id("town.millie.primitive.android.library")
    id("town.millie.primitive.android.kotlin")
    id("town.millie.primitive.android.hilt")
    id("town.millie.primitive.android.compose")
}

android.namespace = "town.millie.feature.newslist"
android.buildFeatures.compose = true

dependencies {
    implementation(libs.bundles.compose.lifecycle)
    implementation(libs.bundles.coil)
    implementation(projects.core.model)
    implementation(projects.core.domain)
}
