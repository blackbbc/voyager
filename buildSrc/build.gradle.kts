plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
    google()
    mavenCentral()
    maven("https://mirrors.tencent.com/nexus/repository/maven-tencent")
    maven("https://mirrors.tencent.com/nexus/repository/maven-public")
    mavenLocal()
}

dependencies {
    implementation(libs.plugin.android)
    implementation(libs.plugin.kotlin)
    implementation("com.squareup:javapoet:1.13.0") // https://github.com/google/dagger/issues/3068
}
