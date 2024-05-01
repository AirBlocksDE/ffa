plugins {
    kotlin("jvm") version "1.9.21"
    id("io.papermc.paperweight.userdev") version "1.5.11"
    id("xyz.jpenilla.run-paper") version "2.0.1"
}

group = "de.airblocks"
version = "1.0"

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    paperweight.paperDevBundle("1.20.4-R0.1-SNAPSHOT")
    implementation("net.axay:kspigot:1.20.3")
    implementation("de.verdox.mccreativelab:plugin-extension:1.20.4-R0.1-SNAPSHOT")
}

tasks.test {
    useJUnitPlatform()
}

tasks.runServer {
    serverJar(File("run/server.jar"))
}

kotlin {
    jvmToolchain(17)
}