package de.airblocks.ffa.extension.bukkit

import de.airblocks.ffa.game.GameEngine
import org.bukkit.entity.Player

val Player.isIngame: Boolean
    get() {
        return when(GameEngine.ingamePlayers.contains(player)) {
            true -> true
            false -> false
        }
    }