import org.lwjgl.Lwjgl

plugins {
    id("org.lwjgl.plugin") version "0.0.20"
}

repositories {
    mavenCentral()

    maven("https://oss.sonatype.org/content/repositories/snapshots/")
    maven("https://raw.github.com/SpinyOwl/repo/releases")
}

dependencies {
    api("com.spinyowl:legui:4.1.0")

    Lwjgl { implementation(Lwjgl.Preset.gettingStarted) }
}