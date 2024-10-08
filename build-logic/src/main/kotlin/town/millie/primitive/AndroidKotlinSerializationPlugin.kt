package town.millie.primitive

import town.millie.ktx.implementation
import town.millie.ktx.library
import town.millie.ktx.libs
import town.millie.ktx.plugin
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidKotlinSerializationPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply(libs.plugin("kotlin-serialization").pluginId)
            }

            dependencies {
                implementation(libs.library("kotlinx-serialization-json"))
            }
        }
    }
}
