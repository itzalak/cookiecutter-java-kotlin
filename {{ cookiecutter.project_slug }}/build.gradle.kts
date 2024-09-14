import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinJvmCompile

val javaVersion: String by project
val springBootVersion: String by project
val springdocVersion: String by project
val springDependencyManagementVersion: String by project
val groovyVersion: String by project
val spockVersion: String by project
val mockkVersion: String by project
val springMockkVersion: String by project

plugins {
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    kotlin("jvm")
    kotlin("plugin.spring")
    groovy
}

apply(from = "project-version.gradle")

group = "io.template"
version = properties["projectVersion"] as String

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web:${springBootVersion}")
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:${springdocVersion}")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    runtimeOnly("com.h2database:h2")

    // Kotlin
    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(module = "mockito-core")
    }
    testImplementation("io.mockk:mockk:${mockkVersion}")
    testImplementation("com.ninja-squad:springmockk:${springMockkVersion}")

    // Groovy
    testImplementation("org.apache.groovy:groovy-all:${groovyVersion}")
    testImplementation("org.spockframework:spock-core:${spockVersion}")
    testImplementation("org.spockframework:spock-spring:${spockVersion}")

    // Java
    testImplementation("org.assertj:assertj-core")
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.springframework:spring-test")
    testImplementation("org.springframework:spring-web")
    testImplementation("org.mockito:mockito-core")
}

tasks {
    java {
        toolchain {
            languageVersion.set(JavaLanguageVersion.of(javaVersion))
        }
    }
    withType<KotlinJvmCompile>().configureEach {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_21)
            freeCompilerArgs.add("-opt-in=kotlin.RequiresOptIn")
        }
    }
    withType<Test> {
        useJUnitPlatform()
    }
}
