plugins {
    id("town.millie.primitive.android.library")
    id("town.millie.primitive.android.kotlin")
    id("town.millie.primitive.android.kotlin.serialization")
    id("town.millie.primitive.android.hilt")
}

android.namespace = "town.millie.contract"
android.buildFeatures.resValues = true
