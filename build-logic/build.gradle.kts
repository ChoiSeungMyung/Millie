import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

group = "town.millie.buildlogic"

repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
}

val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions.jvmTarget = JavaVersion.VERSION_17.toString()

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    implementation(gradleKotlinDsl())
    implementation(libs.kotlin.stdlib)
    implementation(libs.kotlin.gradlePlugin)
    implementation(libs.android.gradlePlugin)
    implementation(libs.hilt.android.gradlePlugin)
    implementation(libs.protobuf.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "town.millie.primitive.android.application"
            implementationClass = "town.millie.primitive.AndroidApplicationPlugin"
        }
        register("androidLibrary") {
            id = "town.millie.primitive.android.library"
            implementationClass = "town.millie.primitive.AndroidLibraryPlugin"
        }
        register("androidProguard") {
            id = "town.millie.primitive.android.proguard"
            implementationClass = "town.millie.primitive.AndroidProguardPlugin"
        }
        register("androidUnitTest") {
            id = "town.millie.primitive.android.unitTest"
            implementationClass = "town.millie.primitive.AndroidKotlinUnitTestPlugin"
        }
        register("androidCompose") {
            id = "town.millie.primitive.android.compose"
            implementationClass = "town.millie.primitive.AndroidComposePlugin"
        }
        register("androidHilt") {
            id = "town.millie.primitive.android.hilt"
            implementationClass = "town.millie.primitive.AndroidHiltPlugin"
        }
        register("androidKotlinPlugin") {
            id = "town.millie.primitive.android.kotlin"
            implementationClass = "town.millie.primitive.AndroidKotlinPlugin"
        }
        register("androidKotlinSerializationPlugin") {
            id = "town.millie.primitive.android.kotlin.serialization"
            implementationClass = "town.millie.primitive.AndroidKotlinSerializationPlugin"
        }
        register("androidKotlinParcelizePlugin") {
            id = "town.millie.primitive.android.kotlin.parcelize"
            implementationClass = "town.millie.primitive.AndroidKotlinParcelizePlugin"
        }
        register("googleProtoBuf") {
            id = "town.millie.primitive.google.protobuf"
            implementationClass = "town.millie.primitive.GoogleProtoBufPlugin"
        }

        // Conventions
        register("androidFeature") {
            id = "town.millie.convention.feature"
            implementationClass = "town.millie.convention.AndroidFeaturePlugin"
        }
    }
}
