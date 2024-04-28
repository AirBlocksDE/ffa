package de.airblocks.ffa.kit.impl

import de.airblocks.ffa.extension.bukkit.toStack
import de.airblocks.ffa.kit.AbstractKit
import net.axay.kspigot.items.itemStack
import net.axay.kspigot.items.meta
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.entity.Player
import org.bukkit.inventory.meta.PotionMeta
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType

class SkyWarsKit : AbstractKit("SkyWars") {
    override val displayMaterial: Material = Material.ENDER_PEARL
    override val hitCooldown: Boolean = true
    private var potion = itemStack(Material.SPLASH_POTION) {
        meta<PotionMeta> {
            addCustomEffect(PotionEffect(PotionEffectType.HEAL, 0, 1), true)
        }
    }

    override fun setPlayer(player: Player) {
        val inventory = player.inventory
        with(inventory) {
            setItemInOffHand(Material.SHIELD.toStack())
            helmet = itemStack(Material.DIAMOND_HELMET) {
                addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2)
            }
            chestplate = itemStack(Material.NETHERITE_CHESTPLATE) {
                addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1)
            }
            leggings = itemStack(Material.DIAMOND_LEGGINGS) {
                addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2)
            }
            boots = itemStack(Material.DIAMOND_BOOTS) {
                addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1)
            }
            setItem(0, itemStack(Material.NETHERITE_SWORD) {
                addEnchantment(Enchantment.DAMAGE_ALL, 2)
            })
            setItem(1, itemStack(Material.DIAMOND_AXE) {})
            setItem(8, itemStack(Material.COBWEB) {
                amount = 16
            })
            setItem(7, itemStack(Material.BRAIN_CORAL_BLOCK) {
                amount = 64
            })
            setItem(3, potion)
            setItem(4, itemStack(Material.GOLDEN_APPLE) {
                amount = 3
            })
            setItem(7, Material.LAVA_BUCKET.toStack())
            setItem(5, itemStack(Material.ENDER_PEARL) {
                amount = 2
            })
            setItem(2, Material.WATER_BUCKET.toStack())
            setItem(9, itemStack(Material.DIAMOND_PICKAXE) {
                addEnchantment(Enchantment.DIG_SPEED, 1)
            })
            setItem(6, itemStack(Material.BRAIN_CORAL_BLOCK) {
                amount = 64
            })
            setItem(22, itemStack(Material.COOKED_BEEF) {
                amount = 34
            })
            setItem(31, Material.FLINT_AND_STEEL.toStack())
            setItem(29, Material.WATER_BUCKET.toStack())
            setItem(33, itemStack(Material.BRAIN_CORAL_BLOCK) {
                amount = 64
            })
            setItem(30, potion)
            setItem(34, Material.LAVA_BUCKET.toStack())
            setItem(29, Material.WATER_BUCKET.toStack())
        }
    }
}