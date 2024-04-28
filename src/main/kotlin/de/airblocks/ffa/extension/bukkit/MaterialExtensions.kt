package de.airblocks.ffa.extension.bukkit

import org.bukkit.Material
import org.bukkit.inventory.ItemStack

fun Material.toStack(): ItemStack {
    return ItemStack(this)
}