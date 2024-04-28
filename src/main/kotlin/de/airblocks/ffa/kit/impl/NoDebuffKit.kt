package de.airblocks.ffa.kit.impl

import de.airblocks.ffa.kit.AbstractKit
import net.axay.kspigot.items.itemStack
import net.axay.kspigot.items.meta
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.entity.Player
import org.bukkit.inventory.meta.PotionMeta
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType

class NoDebuffKit : AbstractKit("NoDebuff") {
    override val displayMaterial: Material = Material.SPLASH_POTION
    override val hitCooldown: Boolean = true
    private var potion = itemStack(Material.SPLASH_POTION) {
        meta<PotionMeta> {
            addCustomEffect(PotionEffect(PotionEffectType.HEAL, 0, 0), true)
        }
    }

    override fun setPlayer(player: Player) {
        val inventory = player.inventory
        val speedPotion = itemStack(Material.POTION) {
            meta<PotionMeta> {
                addCustomEffect(PotionEffect(PotionEffectType.SPEED, 90*20, 1), true)
            }
        }
        with(inventory) {
            for (i in 0..35) {
                setItem(i, potion)
            }
            helmet = itemStack(Material.DIAMOND_HELMET) {
                addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2)
            }
            chestplate = itemStack(Material.DIAMOND_CHESTPLATE) {
                addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2)
            }
            leggings = itemStack(Material.DIAMOND_LEGGINGS) {
                addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2)
            }
            boots = itemStack(Material.DIAMOND_BOOTS) {
                addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2)
            }
            setItem(0, itemStack(Material.DIAMOND_SWORD) {
                addEnchantment(Enchantment.DAMAGE_ALL, 1)
            })
            setItem(7, itemStack(Material.ENDER_PEARL) {
                amount = 16
            })
            setItem(8, itemStack(Material.COOKED_BEEF) {
                amount = 64
            })
            setItem(17, speedPotion)
        }
    }
}