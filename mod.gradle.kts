import com.bizcub.multiloader.MultiLoader
import dev.kikugie.stonecutter.build.StonecutterBuildExtension
import me.modmuss50.mpp.ModPublishExtension

val stonecutter = project.extensions.getByType(StonecutterBuildExtension::class.java)

project.extensions.configure<MultiLoader>("multiloader") {
    project.afterEvaluate {
        stonecutter.let { sc ->
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
            sc.swaps["client_regestry"] = when {
                scp >= "1.19" -> "//ClientRegistry;"
                scp >= "1.18" -> "import net.minecraftforge.client.ClientRegistry;"
                scp >= "1.17" -> "import net.minecraftforge.fmlclient.registry.ClientRegistry;"
                else -> "import net.minecraftforge.fml.client.registry.ClientRegistry;"
            }
        }
    }

    if (isFabric) {
        addDependency("implementation", "net.fabricmc:fabric-loader:latest.release")
        addDependency("implementation", "net.fabricmc.fabric-api:fabric-api:${getProp("fabric_api")}")
    }

    if (isNeoForge) {
        addRepository("https://maven.neoforged.net/releases")
    }

    project.extensions.configure<ModPublishExtension>("publishMods") {
        modrinth {
            if (isFabric) requires("fabric-api")
        }
        curseforge {
            if (isFabric) requires("fabric-api")
        }
    }
}
