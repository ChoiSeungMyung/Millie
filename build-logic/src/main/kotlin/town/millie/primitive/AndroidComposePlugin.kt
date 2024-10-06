package town.millie.primitive

import town.millie.ktx.android
import town.millie.ktx.bundle
import town.millie.ktx.implementation
import town.millie.ktx.ksp
import town.millie.ktx.library
import town.millie.ktx.libs
import town.millie.ktx.plugin
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidComposePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply(libs.plugin("kotlin-compose").pluginId)
            }

            android {
                buildFeatures.compose = true
            }

            dependencies {
                implementation(libs.bundle("compose"))
                implementation(libs.bundle("compose-animation"))
                implementation(libs.bundle("compose-basic"))
                implementation(libs.bundle("compose-ui"))
                implementation(libs.bundle("compose-navigation"))
                implementation(libs.bundle("compose-lifecycle"))
                implementation(libs.library("androidx-hilt-navigation"))
                ksp(libs.library("androidx-hilt-compiler"))
            }
        }
    }
}
