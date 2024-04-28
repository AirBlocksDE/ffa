package de.airblocks.ffa.listener

import de.airblocks.ffa.kit.KitEngine.currentKit
import net.axay.kspigot.event.listen
import org.bukkit.attribute.Attribute
import org.bukkit.entity.Player
import org.bukkit.event.player.PlayerRespawnEvent

object PlayerRespawnListener {
    init {
        listen<PlayerRespawnEvent> {
            val player: Player = it.player
            currentKit.setPlayer(player)
            if (currentKit.hitCooldown) {
                val attackSpeedAttribute = player.getAttribute(Attribute.GENERIC_ATTACK_SPEED) ?: return@listen
                attackSpeedAttribute.baseValue = 4.0
            } else {
                val attackSpeedAttribute = player.getAttribute(Attribute.GENERIC_ATTACK_SPEED) ?: return@listen
                attackSpeedAttribute.baseValue = 100.0
            }
        }
    }
}