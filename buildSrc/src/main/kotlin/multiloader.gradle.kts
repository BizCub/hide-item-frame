plugins {
    id("multiloader-common")
    id("me.modmuss50.mod-publish-plugin")
}

reps.clear()
deps.clear()

if (isFabric) {
    deps.add(Dependency("net.fabricmc:fabric-loader:latest.release", "implementation"))
}

if (isNeoForge) {
    reps.add(Repository("https://maven.neoforged.net/releases"))
}
