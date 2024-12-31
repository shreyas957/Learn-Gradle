import dev.shreyas.CustomTask

plugins {
    id("java")
    id("pl.allegro.tech.build.axion-release") version "1.18.7"
}

group = "dev.shreyas"
version = scmVersion.version

repositories {
    mavenCentral()

//    If you have a private repository, we can configure like this
//    google {
//        name = "Google Maven"
//        url = uri("https://maven.google.com/")
//        credentials {
//            username = "username"
//            password = "password"
//        }
//    }
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()     // This configures tests to use the Junit 5 platform.
}
//  above code is equivalent to below code
//tasks.named<Test>("test") {
//    useJUnitPlatform()
//}

tasks.named<Jar>("jar") {
    manifest {
        attributes["Main-Class"] = "dev.shreyas.Main"
    }
}

// run tests in parallel (preferable for Unit tests)
tasks.test {
    maxParallelForks =
        4   // telling gradle make 4 diff processes to run tests, number is limited by the number of cores in your machine
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)   // If we don't have java 21 it will download it and use it
        vendor = JvmVendorSpec.ORACLE
    }
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}

// Below is the custom task define in buildSrc and declared in this build.gradle.kts
tasks.register<CustomTask>("customTask") {
    input.set("Hello")
}