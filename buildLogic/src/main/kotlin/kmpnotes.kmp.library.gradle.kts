import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    id("org.jetbrains.kotlin.multiplatform")
    id("com.android.kotlin.multiplatform.library")
    id("com.google.devtools.ksp")
}

private val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

kotlin {
    androidLibrary {

        compileSdk = libs.findVersion("androidCompileSdk").get().requiredVersion.toInt()
        minSdk = libs.findVersion("androidMinSdk").get().requiredVersion.toInt()

        compilerOptions {
            jvmTarget = JvmTarget.JVM_11
        }
        androidResources {
            enable = true
        }
        withHostTest {
            isIncludeAndroidResources = true
        }
        withDeviceTestBuilder {
            sourceSetTreeName = "test"
        }.configure {
            instrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        }
    }

    sourceSets {
        commonMain {
            dependencies {
                implementation(project.dependencies.platform(libs.findLibrary("koin-bom").get()))
            }
        }
    }
}

dependencies {}

