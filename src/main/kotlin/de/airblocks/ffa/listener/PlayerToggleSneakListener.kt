package de.airblocks.ffa.listener

import de.airblocks.ffa.WorldManager
import de.airblocks.ffa.game.GameEngine
import de.airblocks.ffa.kit.KitEngine
import de.airblocks.ffa.utils.JoinGame
import net.axay.kspigot.event.listen
import org.bukkit.GameMode
import org.bukkit.attribute.Attribute
import org.bukkit.attribute.AttributeInstance
import org.bukkit.event.player.PlayerToggleSneakEvent

object PlayerToggleSneakListener {

    init {
        listen<PlayerToggleSneakEvent> {
            JoinGame.trigger(it.player)
        }
    }
}