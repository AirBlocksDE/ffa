package de.airblocks.ffa.commands

import de.airblocks.ffa.utils.JoinGame
import net.axay.kspigot.commands.command
import net.axay.kspigot.commands.runs

object JoinCommand {

    init {
        register("join")
        register("play")
        register("joinffa")
        register("playffa")
        register("j")
        register("p")
    }

    private fun register(name: String) = command(name) {
        runs {
            JoinGame.trigger(player)
        }
    }
}