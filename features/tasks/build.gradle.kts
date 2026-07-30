import extension.configureTargets

plugins {
    alias(libs.plugins.kmpnotes.kmp.library)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.koin.compiler)
}
group = "com.vishal.kmpnotes.tasks"
kotlin {
    configureTargets("tasks")
    androidLibrary {
        namespace = "com.vishal.kmpnotes.tasks"
    }

    sourceSets {
        commonMain.dependencies {
            //Compose
            implementation(libs.compose.runtime)
            implementation(libs.compose.foundation)
            implementation(libs.compose.material3)
            implementation(libs.compose.ui)
            implementation(libs.compose.components.resources)
            implementation(libs.androidx.lifecycle.runtimeCompose)

            //Compose Preview
            implementation(libs.compose.uiToolingPreview)

            implementation(libs.androidx.lifecycle.viewmodelCompose)
            implementation(libs.navigation.compose)

            implementation(projects.features.common)
            implementation(projects.shared)
            implementation(projects.domain)

            //Koin
            implementation(libs.koin.core)
            implementation(libs.koin.compose)
        }
    }
}