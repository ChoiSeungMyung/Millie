package town.millie.primitive

import town.millie.ktx.android
import town.millie.ktx.implementation
import town.millie.ktx.kotlinOptions
import town.millie.ktx.library
import town.millie.ktx.libs
import town.millie.ktx.plugin
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

class AndroidKotlinPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply(libs.plugin("kotlin-android").pluginId)
                apply(libs.plugin("kotlin-ksp").pluginId)
            }

            tasks.withType(KotlinCompile::class.java) {
                kotlinOptions.jvmTarget = JavaVersion.VERSION_17.toString()
            }

            android {
                kotlinOptions {
                    jvmTarget = JavaVersion.VERSION_17.toString()

                    freeCompilerArgs =
                        listOf(
                            "-opt-in=kotlin.RequiresOptIn",
                            "-Xcontext-receivers",
                        )
                }
            }

            dependencies {
                implementation(libs.library("kotlin-stdlib"))
                implementation(libs.library("kotlin-stdlib-jdk8"))
                implementation(libs.library("kotlin-reflection"))
                implementation(libs.library("kotlinx-coroutines-core"))
                implementation(libs.library("kotlinx-coroutines-android"))
            }
        }
    }
}
