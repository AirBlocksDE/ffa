package de.airblocks.ffa.utils

import de.airblocks.ffa.WorldManager
import de.airblocks.ffa.game.GameEngine
import de.airblocks.ffa.kit.KitEngine
import org.bukkit.GameMode
import org.bukkit.attribute.Attribute
import org.bukkit.attribute.AttributeInstance
import org.bukkit.entity.Player

object JoinGame {

    fun trigger(player: Player) {
        if (GameEngine.ingamePlayers.contains(player)) return
        if (GameEngine.spectatorPlayers.contains(player)) return
        KitEngine.currentKit.setPlayer(player)
        if (KitEngine.currentKit.hitCooldown) {
            val attackSpeedAttribute: AttributeInstance? = player.getAttribute(Attribute.GENERIC_ATTACK_SPEED)
            attackSpeedAttribute?.baseValue = 4.0
        } else {
            val attackSpeedAttribute: AttributeInstance? = player.getAttribute(Attribute.GENERIC_ATTACK_SPEED)
            attackSpeedAttribute?.baseValue = 100.0
        }
        GameEngine.ingamePlayers.add(player)
        player.gameMode = GameMode.SURVIVAL
        player.teleport(WorldManager.randomLocation())
    }
}