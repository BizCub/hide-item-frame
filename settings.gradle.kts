pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
        maven("https://maven.fabricmc.net/")
        maven("https://maven.architectury.dev")
        maven("https://maven.minecraftforge.net")
        maven("https://maven.neoforged.net/releases/")
        maven("https://maven.kikugie.dev/snapshots")
    }
}

plugins {
    id("dev.kikugie.stonecutter") version "0.5"
}

stonecutter {
    centralScript = "build.gradle.kts"
    kotlinController = true
    shared {
        fun mc(loader: String, vararg versions: String) {
            for (version in versions) vers("$version-$loader", version)
        }
        mc("fabric", "1.16", "1.21.2", "1.21.4")
        mc("forge", "1.18.2", "1.20.6", "1.21.3", "1.21.4")
        mc("neoforge", "1.21", "1.21.2", "1.21.4")
    }
    create(rootProject)
}

rootProject.name = settings.extra["mod.name"] as String
