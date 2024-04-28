package de.airblocks.ffa.kit.impl

import de.airblocks.ffa.extension.bukkit.toStack
import de.airblocks.ffa.kit.AbstractKit
import net.axay.kspigot.items.itemStack
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.entity.Player

class NetheriteKit : AbstractKit("Netherite") {
    override val displayMaterial: Material = Material.NETHERITE_INGOT
    override val hitCooldown: Boolean = true

    override fun setPlayer(player: Player) {
        with(player.inventory) {
            setItemInOffHand(Material.SHIELD.toStack())
            helmet = itemStack(Material.NETHERITE_HELMET) {
                addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2)
            }
            chestplate = itemStack(Material.NETHERITE_CHESTPLATE) {
                addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2)
            }
            leggings = itemStack(Material.NETHERITE_LEGGINGS) {
                addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2)
            }
            boots = itemStack(Material.NETHERITE_BOOTS) {
                addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4)
            }
            setItem(0, itemStack(Material.NETHERITE_SWORD) {
                addEnchantment(Enchantment.DAMAGE_ALL, 3)
            })
            setItem(1, Material.NETHERITE_AXE.toStack())
            setItem(3, itemStack(Material.DEAD_BRAIN_CORAL_BLOCK) {
                amount = 64
            })
            setItem(5, itemStack(Material.COOKED_BEEF) {
                amount = 34
            })
            setItem(4, Material.FLINT_AND_STEEL.toStack())
            setItem(2, Material.WATER_BUCKET.toStack())
            setItem(9, itemStack(Material.NETHERITE_PICKAXE) {
                addEnchantment(Enchantment.DIG_SPEED, 2)
            })
            setItem(7, itemStack(Material.DEAD_BRAIN_CORAL_BLOCK) {
                amount = 64
            })
            setItem(8, itemStack(Material.DEAD_BRAIN_CORAL_BLOCK) {
                amount = 64
            })
        }
    }
}