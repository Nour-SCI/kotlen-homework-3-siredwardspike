group = rootProject.group
version = rootProject.version
plugins {
    kotlin("jvm")
}
tasks.test {
    useJUnitPlatform()
}


dependencies {
    implementation(project(":module2"))
    testImplementation(libs.junit.api)
    testImplementation(libs.junit.params)
    testRuntimeOnly(libs.junit.engine)
}

