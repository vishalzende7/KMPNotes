import extension.configureTargets

plugins {
    alias(libs.plugins.kmpnotes.kmp.library)
    alias(libs.plugins.androidLint)
    alias (libs.plugins.koin.compiler)
    alias(libs.plugins.androidx.room)
}
room {
    schemaDirectory("$projectDir/schemas")
}

kotlin {

    android {
        namespace = "com.vishal.data"
    }

    // For iOS targets, this is also where you should
    // configure native binary output. For more information, see:
    // https://kotlinlang.org/docs/multiplatform-build-native-binaries.html#build-xcframeworks

    // A step-by-step guide on how to include this library in an XCode
    // project can be found here:
    // https://developer.android.com/kotlin/multiplatform/migrate
    configureTargets("dataKit")

    sourceSets {
        commonMain {
            dependencies {
                implementation(projects.domain)

                implementation(libs.kotlin.stdlib)
                implementation(libs.kotlinx.coroutinesCore)

                implementation(libs.room.runtime)
//                implementation(libs.room.ktx)
                implementation(libs.room.common)
                implementation(libs.androidx.sqlite.bundled)

                //Koin
                implementation(libs.koin.core)

            }
        }

        commonTest {
            dependencies {
                implementation(libs.kotlin.test)
            }
        }

        androidMain {
            dependencies {
                // Add Android-specific dependencies here. Note that this source set depends on
                // commonMain by default and will correctly pull the Android artifacts of any KMP
                // dependencies declared in commonMain.
                implementation(libs.androidx.room.sqlite.wrapper)
            }
        }

        getByName("androidDeviceTest") {
            dependencies {
                implementation(libs.androidx.core)
                implementation(libs.androidx.runner)
                implementation(libs.androidx.testExt.junit)
            }
        }

        iosMain {
            dependencies {
                // Add iOS-specific dependencies here. This a source set created by Kotlin Gradle
                // Plugin (KGP) that each specific iOS target (e.g., iosX64) depends on as
                // part of KMP’s default source set hierarchy. Note that this source set depends
                // on common by default and will correctly pull the iOS artifacts of any
                // KMP dependencies declared in commonMain.
            }
        }
    }

}

dependencies {
    ksp(libs.room.compiler)
    add("kspAndroid", libs.room.compiler)
    add("kspIosSimulatorArm64", libs.room.compiler)
    add("kspIosArm64", libs.room.compiler)
    add("kspJvm", libs.room.compiler)
}