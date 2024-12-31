plugins {
    id("java")
    id("pl.allegro.tech.build.axion-release") version "1.18.7"
}

group = "dev.shreyas"
version = scmVersion.version

repositories {
    mavenCentral()
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