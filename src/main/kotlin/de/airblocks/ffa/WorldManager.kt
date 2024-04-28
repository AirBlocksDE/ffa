package de.airblocks.ffa

import org.bukkit.Bukkit
import org.bukkit.Difficulty
import org.bukkit.Location
import org.bukkit.Material
import java.util.concurrent.ThreadLocalRandom

object WorldManager {
    var blocks = HashMap<Location, Material>()

    fun setupWorld() {
        val world = Bukkit.getWorld("world")
        world?.difficulty = Difficulty.HARD
        world?.pvp = true
        world?.worldBorder?.size = 150.0
    }

    fun resetWorld() {
        for (block in blocks) {
            block.key.block.type = block.value
        }
    }

    fun randomLocation(): Location {
        val x = ThreadLocalRandom.current().nextInt(-74, 74 + 1)
        val z = ThreadLocalRandom.current().nextInt(-74, 74 + 1)
        val y = Bukkit.getWorld("world")?.getHighestBlockAt(x, z)?.y?.toDouble()!! + 1
        return Location(Bukkit.getWorld("world"), x.toDouble(), y, z.toDouble())
    }
}