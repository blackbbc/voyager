plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("org.jetbrains.compose")
    id("com.vanniktech.maven.publish")
    alias(libs.plugins.composeCompiler)
}

version = findProperty("VERSION_NAME") as String

setupModuleForComposeMultiplatform(
    fullyMultiplatform = true
)

android {
    namespace = "cafe.adriel.voyager.koin"
    defaultConfig {
        consumerProguardFiles("consumer-rules.pro")
    }
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.voyagerCore)
            api(projects.voyagerScreenmodel)
            api(projects.voyagerNavigator)

            compileOnly(compose.runtime)
            compileOnly(compose.runtimeSaveable)
            compileOnly(compose.ui)

            implementation(libs.coroutines.core)
        }
    }
}

dependencies {
    commonMainImplementation(libs.koin.compose) {
        exclude("org.jetbrains.compose.runtime")
    }
}
