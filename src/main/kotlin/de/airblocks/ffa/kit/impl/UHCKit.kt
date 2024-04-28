package de.airblocks.ffa.kit.impl

import de.airblocks.ffa.kit.AbstractKit
import net.axay.kspigot.event.listen
import net.axay.kspigot.event.register
import net.axay.kspigot.event.unregister
import net.axay.kspigot.items.itemStack
import net.axay.kspigot.items.meta
import net.axay.kspigot.items.name
import net.kyori.adventure.text.Component
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.entity.Player
import org.bukkit.event.player.PlayerItemConsumeEvent

class UHCKit : AbstractKit("UHC") {
    override val displayMaterial: Material = Material.GOLDEN_APPLE
    override val hitCooldown: Boolean = true

    override fun onEnable() {
        playerConsumeItem.register()
    }

    override fun onDisable() {
        playerConsumeItem.unregister()
    }

    override fun setPlayer(player: Player) {
        val inventory = player.inventory
        //OFFHAND
        inventory.setItemInOffHand(itemStack(Material.SHIELD) {
            meta {
                addEnchant(Enchantment.DURABILITY, 1,false)
            }
        })
        //ARMOR
        inventory.helmet = itemStack(Material.DIAMOND_HELMET) {
            meta {
                addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, false)
            }
        }
        inventory.chestplate = itemStack(Material.DIAMOND_CHESTPLATE) {
            meta {
                addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, false)
            }
        }
        inventory.leggings = itemStack(Material.DIAMOND_LEGGINGS) {
            meta {
                addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, false)
            }
        }
        inventory.boots = itemStack(Material.DIAMOND_BOOTS) {
            meta {
                addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, false)
            }
        }
        //INVENTORY
        with(player.inventory) {
            setItem(0, itemStack(Material.DIAMOND_SWORD) {
                addEnchantment(Enchantment.DAMAGE_ALL, 1)
            })
            setItem(1, itemStack(Material.DIAMOND_AXE) {
                addEnchantment(Enchantment.DURABILITY, 1)
            })
            setItem(8, itemStack(Material.COBWEB) {
                amount = 32
            })
            setItem(6, itemStack(Material.COBBLESTONE) {
                amount = 64
            })
            setItem(7, itemStack(Material.GOLDEN_APPLE) {
                amount = 24
            })
            setItem(34, itemStack(Material.GOLDEN_APPLE) {
                meta {
                    name = Component.text("§fGolden Head")
                }
                amount = 3
            })
            setItem(5, itemStack(Material.LAVA_BUCKET) {})
            setItem(4, itemStack(Material.CROSSBOW) {})
            setItem(2, itemStack(Material.WATER_BUCKET) {})
            setItem(33, itemStack(Material.COBBLESTONE) {
                amount = 64
            })
            setItem(31, itemStack(Material.COOKED_BEEF) {
                amount = 38
            })
            setItem(32, itemStack(Material.LAVA_BUCKET) {})
            setItem(29, itemStack(Material.WATER_BUCKET) {})

            setItem(6, itemStack(Material.COBBLESTONE) {
                amount = 64
            })
            setItem(9, itemStack(Material.DIAMOND_PICKAXE) {
                addEnchantment(Enchantment.DIG_SPEED, 2)
            })
            setItem(10, itemStack(Material.DIAMOND_SHOVEL) {
                addEnchantment(Enchantment.DURABILITY, 1)
            })
            setItem(11, itemStack(Material.ARROW) {
                amount = 14
            })
            setItem(12, itemStack(Material.COBBLESTONE) {
                amount = 64
            })
        }
    }

    private val playerConsumeItem = listen<PlayerItemConsumeEvent>(register = false) {
        val player = it.player
        if (it.item.itemMeta.name?.equals("§fGolden Head") == true) {
            if (player.health >= 5) {
                player.health = 20.0
            } else {
                player.health = player.health + 15
            }
        }
    }
}