plugins {
    id("town.millie.primitive.android.library")
    id("town.millie.primitive.android.kotlin")
    id("town.millie.primitive.android.hilt")
    id("town.millie.primitive.android.compose")
}

android.namespace = "town.millie.presentation"
android.buildFeatures.compose = true

dependencies {
    implementation(projects.core.model)
    implementation(projects.core.domain)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.fragment)
    implementation(libs.bundles.lifecycle)
    implementation(projects.core.designsystem)
    implementation(projects.feature.newslist)
    implementation(projects.feature.newsdetail)
}
