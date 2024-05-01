package de.airblocks.ffa.customization

import de.airblocks.ffa.hud.IngameHud
import de.verdox.mccreativelab.MCCreativeLabExtension

object CustomizationRegistry {

    val resources = listOf(IngameHud())

    fun initialize() {
        resources.forEach { MCCreativeLabExtension.getCustomResourcePack().register(it) }
    }
}