import java.util.Optional
import org.gradle.api.tasks.testing.logging.TestExceptionFormat

plugins {
    java
    alias(libs.plugins.lombok)
    alias(libs.plugins.spring.boot)
}

repositories {
    mavenCentral()
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

dependencies {
    compileOnly(libs.jwt.api)

    runtimeOnly(libs.jwt.impl)
    runtimeOnly(libs.jwt.jackson)

    implementation(libs.spring.boot.starter.security)
    implementation(libs.spring.boot.starter.web)
    implementation(libs.springdoc.ui)
}

testing {
    suites {
        val test by getting(JvmTestSuite::class) {
            useJUnitJupiter()

            dependencies {
                implementation(project())

                implementation(libs.karate)
                implementation(libs.spring.boot.starter.test)
            }

            targets {
                configureEach {
                    testTask.configure {
                        Optional.ofNullable(System.getProperties()["app.server.port"])
                            .ifPresent { systemProperty("app.server.port", it) }

                        testLogging {
                            showStackTraces = true
                            showStandardStreams = project.properties
                                .getOrDefault("testLogging.showStandardStreams", true)
                                .toString()
                                .toBoolean()
                            exceptionFormat = TestExceptionFormat.FULL
                        }
                    }
                }
            }
        }
    }
}

tasks {
    bootRun {
        Optional.ofNullable(System.getProperties()["server.port"])
            .ifPresent { systemProperty("server.port", it) }
        Optional.ofNullable(System.getProperties()["jwt.expiration.ms"])
            .ifPresent { systemProperty("jwt.expiration.ms", it) }
        Optional.ofNullable(System.getProperties()["jwt.secret"])
            .ifPresent { systemProperty("jwt.secret", it) }
    }
}
