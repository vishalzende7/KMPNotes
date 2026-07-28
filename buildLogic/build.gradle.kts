plugins {
    `kotlin-dsl`
//    `kotlin-dsl-precompiled-script-plugins`

}

group = "com.vishal.kmpnotes.buildlogic"
repositories {
    mavenCentral()
    google()
    gradlePluginPortal()
}

dependencies {
    implementation(libs.android.gradlePlugin)
    implementation(libs.kotlin.gradlePlugin)
    implementation(libs.ksp.gradlePlugin)
}