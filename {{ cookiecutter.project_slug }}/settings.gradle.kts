pluginManagement {
    val kotlinVersion: String by settings
    val springBootVersion: String by settings
    val springDependencyManagementVersion: String by settings

    repositories {
        mavenLocal()
        gradlePluginPortal()
        plugins {
            id("org.jetbrains.kotlin.jvm") version kotlinVersion
            id("org.jetbrains.kotlin.plugin.spring") version kotlinVersion
            id("org.springframework.boot") version springBootVersion
            id("io.spring.dependency-management") version springDependencyManagementVersion
        }
    }
}

rootProject.name = "{{ cookiecutter.project_slug }}"
