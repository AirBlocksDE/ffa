package de.airblocks.ffa.listener

import de.airblocks.ffa.WorldManager
import net.axay.kspigot.event.listen
import org.bukkit.Material
import org.bukkit.event.block.BlockBreakEvent

object BlockBreakListener {
    init {
        listen<BlockBreakEvent> {
            val location = it.block.location
            val blockType: Material = it.block.type
            if (!WorldManager.blocks.contains(location)) {
                WorldManager.blocks[location] = blockType
            }
        }
    }
}