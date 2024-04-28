package de.airblocks.ffa.commands

import com.mojang.brigadier.arguments.StringArgumentType
import de.airblocks.ffa.kit.KitEngine
import de.airblocks.ffa.kit.KitEngine.kits
import de.airblocks.ffa.utils.Values
import net.axay.kspigot.chat.KColors
import net.axay.kspigot.chat.literalText
import net.axay.kspigot.commands.argument
import net.axay.kspigot.commands.command
import net.axay.kspigot.commands.runs
import net.axay.kspigot.commands.suggestList

object ForceKitCommand {
    init {
        command("forcekit") {
            requires { it.bukkitSender.hasPermission("ffa.forcekit") }
            argument<String>("kit", StringArgumentType.word()) {
                suggestList { kits.map { it.displayName } }
                runs {
                    val kit = kits.first { it.displayName.lowercase() == getArgument<String>("kit").lowercase() }
                    KitEngine.changeKit(kit)
                }
            }
            runs {
                player.sendMessage(Values.PREFIX.append(literalText("Syntax: /forcekit <kit>") {
                    color = KColors.TOMATO
                }))
            }
        }
    }
}