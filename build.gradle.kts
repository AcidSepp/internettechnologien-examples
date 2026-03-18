plugins {
    java
    alias(libs.plugins.kotlin)
    alias(libs.plugins.springBoot)
    alias(libs.plugins.springDeps)
}

repositories {
    mavenCentral()
}

springBoot {
    mainClass.set("de.haw.landshut.itt.rest.SpringMain")
}

dependencies {
    implementation(libs.bson)
    implementation(libs.jackson)
    implementation(libs.jakarta.xml.bind)
    implementation(libs.jaxb.runtime)
    implementation(libs.json.schema)
    implementation(libs.spring.starter.validation)
    implementation(libs.spring.starter.web)

    testImplementation(libs.assertj)
    testImplementation(libs.mockito)
    testImplementation(libs.spring.starter.test)
    testImplementation(libs.spring.starter.webflux)
}

testing.suites.named<JvmTestSuite>("test") {
    useJUnitJupiter(libs.versions.junit.jupiter)
}

// Apply a specific Java toolchain to ease working on different environments.
java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(25)
    }
}
