plugins {
    id("me.modmuss50.mod-publish-plugin")
    id("dev.kikugie.fletching-table")
    id("com.bizcub.multiloader")
}

multiloader {
    setMREnvironment(mrEnvs.clientOnly)
    setCFEnvironment(cfEnvs.client)

    sc.replacements {
        string(scp >= "26.1") {
            replace("KeyBindingHelper", "KeyMappingHelper")
            replace("registerKeyBinding", "registerKeyMapping")
        }
        string(scp >= "1.21.6") {
            replace("net.minecraftforge.eventbus.api.SubscribeEvent",
                "net.minecraftforge.eventbus.api.listener.SubscribeEvent")
        }
    }

    sc.swaps["client_registry"] = when {
        scp >= "1.19" -> "//ClientRegistry;"
        scp >= "1.18" -> "import net.minecraftforge.client.ClientRegistry;"
        scp >= "1.17" -> "import net.minecraftforge.fmlclient.registry.ClientRegistry;"
        else -> "import net.minecraftforge.fml.client.registry.ClientRegistry;"
    }

    if (isFabric) {
        addDependency(
            dependency = "net.fabricmc:fabric-loader:${getDep("fabric")}"
        )
        addDependency(
            dependency = "net.fabricmc.fabric-api:fabric-api:${getDep("fabric-api")}",
            isPublishDepEnabled = true,
            isPublishDepRequired = true
        )
    }
}
