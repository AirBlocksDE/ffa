package de.airblocks.ffa

import de.airblocks.ffa.commands.ForceKitCommand
import de.airblocks.ffa.commands.JoinCommand
import de.airblocks.ffa.game.GameScheduler
import de.airblocks.ffa.kit.KitEngine
import de.airblocks.ffa.listener.*
import net.axay.kspigot.main.KSpigot

class FFA: KSpigot() {

    companion object {
        lateinit var INSTANCE: FFA; private set
    }

    override fun load() {
        INSTANCE = this
    }

    override fun startup() {
        PlayerJoinListener
        PlayerQuitListener
        PlayerRespawnListener
        PlayerDeathListener
        PlayerToggleSneakListener
        BlockPlaceListener
        BlockBreakListener

        ForceKitCommand
        JoinCommand

        KitEngine.setNewRandomKit()
        WorldManager.setupWorld()
        GameScheduler().runTaskTimer(this, 0, 20)
    }
}