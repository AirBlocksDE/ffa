package de.airblocks.ffa.hud

import de.airblocks.ffa.FFA.Companion.gameScheduler
import de.airblocks.ffa.kit.KitEngine
import de.airblocks.ffa.utils.getTimeAsString
import de.verdox.mccreativelab.generator.resourcepack.types.hud.CustomHud
import de.verdox.mccreativelab.generator.resourcepack.types.rendered.RenderedElementBehavior
import de.verdox.mccreativelab.generator.resourcepack.types.rendered.util.ScreenPosition
import de.verdox.mccreativelab.util.io.StringAlign
import net.axay.kspigot.chat.KColors
import net.kyori.adventure.text.Component
import org.bukkit.NamespacedKey

class IngameHud: CustomHud(NamespacedKey("airblocks-ffa", "ingamehud")) {

    init {
        withText("currentKit", ScreenPosition(50, 98, 0F, 0F,0), StringAlign.Alignment.CENTER,
            RenderedElementBehavior.createWhileOpen { _, _, renderedSingleHudText ->
                renderedSingleHudText.renderedText = Component.text("Aktuelles Kit: ").color(KColors.GRAY)
                    .append {
                        Component.text(KitEngine.currentKit.displayName).color(KColors.GREENYELLOW)
                    }
            }
        )
        withText("kitChangeTimeDisplay", ScreenPosition(35, 98, 0F, 0F,0), StringAlign.Alignment.RIGHT,
            RenderedElementBehavior.createWhileOpen { _, _, renderedSingleHudText ->
                renderedSingleHudText.renderedText = Component.text("Neues Kit in: ").color(KColors.GRAY)
                    .append {
                        Component.text(getTimeAsString(gameScheduler.kitChangeTime - gameScheduler.kitTime)).color(KColors.GREENYELLOW)
                    }
            }
        )
        withText("newMapTime", ScreenPosition(65, 98, 0F, 0F,0), StringAlign.Alignment.LEFT,
            RenderedElementBehavior.createWhileOpen { _, _, renderedSingleHudText ->
                renderedSingleHudText.renderedText = Component.text("Neue Map in: ").color(KColors.GRAY)
                    .append {
                        Component.text(getTimeAsString(gameScheduler.resetTime - gameScheduler.currentTime)).color(KColors.GREENYELLOW)
                    }
            }
        )
    }
}