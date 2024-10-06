package town.millie.primitive

import town.millie.ktx.libs
import town.millie.ktx.plugin
import org.gradle.api.Plugin
import org.gradle.api.Project

class AndroidKotlinParcelizePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply(libs.plugin("kotlin-parcelize").pluginId)
            }
        }
    }
}
