package town.millie.primitive

import town.millie.ktx.android
import town.millie.ktx.hilt
import town.millie.ktx.implementation
import town.millie.ktx.ksp
import town.millie.ktx.library
import town.millie.ktx.libs
import town.millie.ktx.plugin
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidHiltPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply(libs.plugin("hilt").pluginId)
                apply(libs.plugin("kotlin-ksp").pluginId)
            }

            android {
                packagingOptions {
                    resources {
                        excludes += "META-INF/gradle/incremental.annotation.processors"
                    }
                }
            }

            dependencies {
                implementation(libs.library("hilt"))
                ksp(libs.library("hilt-compiler"))
                implementation(libs.library("kotlinx-ksp"))
            }

            hilt {
                enableAggregatingTask = true
            }
        }
    }
}
