package de.airblocks.ffa.kit.impl

import de.airblocks.ffa.kit.AbstractKit
import net.axay.kspigot.event.listen
import net.axay.kspigot.event.register
import net.axay.kspigot.event.unregister
import net.axay.kspigot.items.itemStack
import net.axay.kspigot.items.meta
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.player.PlayerInteractEvent

class SoupKit : AbstractKit("Soup") {
    override val displayMaterial: Material = Material.MUSHROOM_STEW
    override val hitCooldown: Boolean = false
    val healValue: Int = 3

    override fun onEnable() {
        playerInteractEvent.register()
    }

    override fun onDisable() {
        playerInteractEvent.unregister()
    }

    override fun setPlayer(player: Player) {
        for(i in 1..35) {
            player.inventory.setItem(i, itemStack(Material.MUSHROOM_STEW) {})
        }

        player.inventory.helmet = itemStack(Material.IRON_HELMET) {}
        player.inventory.chestplate = itemStack(Material.IRON_CHESTPLATE) {}
        player.inventory.leggings = itemStack(Material.IRON_LEGGINGS) {}
        player.inventory.boots = itemStack(Material.IRON_BOOTS) {}

        player.inventory.setItem(0, itemStack(Material.STONE_SWORD) {
            meta {
                isUnbreakable = true
            }
        })
        player.inventory.setItem(13, itemStack(Material.BOWL) {
            amount = 64
        })
        player.inventory.setItem(14, itemStack(Material.RED_MUSHROOM) {
            amount = 64
        })
        player.inventory.setItem(15, itemStack(Material.BROWN_MUSHROOM) {
            amount = 64
        })
    }

    val playerInteractEvent = listen<PlayerInteractEvent>(register = false) {
        var player: Player = it.player
        if (!it.item?.type?.equals(Material.MUSHROOM_STEW)!!) return@listen
        if (player.health == 20.0) return@listen

        if (player.health >=18) {
            player.health = 20.0
            it.item!!.type = Material.BOWL
        } else {
            player.health = player.health + healValue
            it.item!!.type = Material.BOWL
        }
    }
}