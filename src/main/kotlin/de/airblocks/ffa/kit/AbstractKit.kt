package de.airblocks.ffa.kit

import org.bukkit.Material
import org.bukkit.entity.Player

abstract class AbstractKit(val displayName: String) {
    abstract val displayMaterial: Material //für ForceKitSelector (falls ich es mache)
    abstract val hitCooldown: Boolean
    open fun onEnable() {}
    open fun onDisable() {}
    open fun setPlayer(player: Player) {}
}