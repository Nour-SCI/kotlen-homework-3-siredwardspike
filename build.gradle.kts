import buildutils.configureDetekt
import buildutils.createDetektTask
import buildutils.configureDiktat
import buildutils.createDiktatTask
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

@Suppress("DSL_SCOPE_VIOLATION") // "libs" produces a false-positive warning, see https://youtrack.jetbrains.com/issue/KTIJ-19369
plugins {
    id(libs.plugins.kotlin.jvm.get().pluginId)
    alias(libs.plugins.buildconfig) apply false
    id("io.gitlab.arturbosch.detekt") version "1.20.0"
}

group = "org.example"
version = "1.0-SNAPSHOT"

subprojects {
    repositories {
        mavenCentral()
    }

    plugins.withId("org.jetbrains.kotlin.jvm") {
        dependencies {
            implementation(libs.junit.api)
            runtimeOnly(libs.junit.engine)
            runtimeOnly(libs.junit.console)
        }


        tasks.withType<KotlinCompile> {
            kotlinOptions.jvmTarget = "1.8"
        }

        configureDiktat()
        configureDetekt()
    }
}

createDiktatTask()
createDetektTask()
