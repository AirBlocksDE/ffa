package de.airblocks.ffa.listener

import de.airblocks.ffa.WorldManager
import net.axay.kspigot.event.listen
import org.bukkit.event.block.BlockPlaceEvent

object BlockPlaceListener {
    init {
        listen<BlockPlaceEvent> {
            val location = it.block.location
            if (!WorldManager.blocks.contains(location))  {
                WorldManager.blocks[location] = it.blockReplacedState.type
            }
        }
    }
}