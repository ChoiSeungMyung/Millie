package town.millie.primitive

import town.millie.internal.proguardPath
import town.millie.internal.release
import town.millie.ktx.android
import org.gradle.api.Plugin
import org.gradle.api.Project

class AndroidProguardPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            android {
                buildTypes {
                    release {
                        isMinifyEnabled = true
                        proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"))
                        proguardPath("$projectDir/proguard")
                    }
                }
            }
        }
    }
}
