import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "com.brianberliner.openc2"
version = "1.0-SNAPSHOT"

plugins {
    kotlin("jvm") version "1.3.31"
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation(kotlin("reflect"))

    implementation("org.leadpony.justify", "justify", "0.16.0")
    implementation("org.glassfish", "javax.json", "1.1.4")
    implementation("com.github.ajalt", "clikt", "1.6.0")

    testImplementation("org.junit.jupiter", "junit-jupiter-api", "5.4.0")
    testImplementation("org.junit.jupiter", "junit-jupiter-engine", "5.4.0")
    testImplementation("org.junit.jupiter", "junit-jupiter-params", "5.4.0")
    testImplementation("com.willowtreeapps.assertk", "assertk-jvm", "0.16")
}

application.mainClassName = "com.brianberliner.openc2.MainKt"

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

tasks.withType<Test> {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
}
