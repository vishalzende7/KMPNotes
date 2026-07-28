import extension.configureTargets

plugins {
    alias(libs.plugins.kmpnotes.kmp.library)
    alias(libs.plugins.androidLint)
}

group = "com.vishal.domain"

kotlin {
    configureTargets("domain")
    androidLibrary {
        namespace = "com.vishal.domain"
    }

    sourceSets {
        commonMain {
            dependencies {
                implementation(libs.kotlin.stdlib)
                implementation(libs.kotlinx.coroutinesCore)
                // Add KMP dependencies here
            }
        }

        commonTest {
            dependencies {
                implementation(libs.kotlin.test)
            }
        }
    }

}