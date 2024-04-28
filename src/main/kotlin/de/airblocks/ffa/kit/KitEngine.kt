package de.airblocks.ffa.kit

import de.airblocks.ffa.kit.impl.*
import de.airblocks.ffa.utils.Values
import net.axay.kspigot.chat.KColors
import net.axay.kspigot.chat.col
import net.axay.kspigot.chat.literalText
import net.axay.kspigot.extensions.onlinePlayers
import net.axay.kspigot.extensions.server
import net.axay.kspigot.items.itemStack
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.attribute.Attribute
import org.bukkit.attribute.AttributeInstance
import org.bukkit.inventory.EquipmentSlot

object KitEngine {
    val kits = setOf(
        UHCKit(),
        SoupKit(),
        SkyWarsKit(),
        NetheriteKit(),
        NoDebuffKit()
    )

    private var oldKit: AbstractKit? = null
    var currentKit = kits.random()

    fun setNewRandomKit() {
        changeKit(kits.filter { it != oldKit }.random())
    }

    fun changeKit(newKit: AbstractKit) {
        oldKit = currentKit
        currentKit = newKit
        oldKit!!.onDisable()
        currentKit.onEnable()
        for (player in onlinePlayers) {

            player.inventory.clear()
            player.foodLevel = 307
            player.health = 20.0
            player.equipment.setItem(EquipmentSlot.HEAD, itemStack(Material.AIR) {})
            player.equipment.setItem(EquipmentSlot.CHEST, itemStack(Material.AIR) {})
            player.equipment.setItem(EquipmentSlot.LEGS, itemStack(Material.AIR) {})
            player.equipment.setItem(EquipmentSlot.FEET, itemStack(Material.AIR) {})
            currentKit.setPlayer(player)

            player.sendMessage(" ")
            player.sendMessage(Values.PREFIX.append(literalText {
                text("KIT WECHSEL") {
                    bold = true
                    color = KColors.GREENYELLOW
                }
            }))
            player.sendMessage(literalText {
                text("Neues Kit") {
                    color = KColors.ALICEBLUE
                }
                text(": ") {
                    color = KColors.SLATEGRAY
                }
                text(currentKit.displayName) {
                    color = KColors.LIGHTGREEN
                }
            })
            val seed = server.getWorld("world")?.seed?.toString() ?: "0"
            player.sendMessage(literalText {
                text("Neuer Seed") {
                    color = KColors.ALICEBLUE
                }
                text(": ") {
                    color = KColors.SLATEGRAY
                }
                text(seed) {
                    color = KColors.LIGHTGREEN
                    onClickCopy(seed)
                    hoverText("Klicke um den Seed zu kopieren") {
                        color = KColors.SLATEGRAY
                        italic = true
                    }
                }
            })
            if (currentKit.hitCooldown) {
                val attackSpeedAttribute: AttributeInstance? = player.getAttribute(Attribute.GENERIC_ATTACK_SPEED)
                attackSpeedAttribute?.baseValue = 4.0
            } else {
                val attackSpeedAttribute: AttributeInstance? = player.getAttribute(Attribute.GENERIC_ATTACK_SPEED)
                attackSpeedAttribute?.baseValue = 100.0
            }
        }
    }
}