package de.airblocks.ffa.game

import de.airblocks.ffa.extension.bukkit.isIngame
import de.airblocks.ffa.kit.KitEngine
import de.airblocks.ffa.utils.Values
import net.axay.kspigot.chat.KColors
import net.axay.kspigot.chat.literalText
import net.axay.kspigot.extensions.onlinePlayers
import net.kyori.adventure.text.Component
import org.bukkit.Bukkit
import org.bukkit.scheduler.BukkitRunnable

class GameScheduler: BukkitRunnable() {
    private val resetTime = 60 * 30
    private val kitChangeTime = 5 * 60
    private var currentTime = 0
    private var kitTime = 0

    override fun run() {
        if(kitTime >= kitChangeTime) {
            //TODO: (new map)
            kitTime = 0
            KitEngine.setNewRandomKit()
        }
        kitTime++
        currentTime++
        for (player in onlinePlayers) {
            val calculatedKitTime: Int = kitChangeTime - kitTime
            val calculatedResetTime: Int = resetTime - currentTime

            if (player.isIngame) {
                player.sendActionBar(literalText {
                    text("Reset: ") {
                        color = KColors.CADETBLUE
                    }
                    text(getTimeAsString(calculatedResetTime)) {
                        color = KColors.LIME
                    }
                    text(" | ") {
                        color = KColors.DARKSLATEGRAY
                    }
                    text("Kitwechsel: ") {
                        color = KColors.CADETBLUE
                    }
                    text(getTimeAsString(calculatedKitTime)) {
                        color = KColors.LIME
                    }
                })
            } else {
                player.sendActionBar(Component.keybind("key.sneak").color(KColors.YELLOWGREEN).append(Component.text("  or /j").color(KColors.YELLOWGREEN)).append(Component.text(" um dem Spiel beizutreten.").color(KColors.SLATEGRAY))) // not using kspigot component dsl here for keybind compatibility
            }
        }
        if (currentTime >= resetTime) {
            kickPlayers()
            Bukkit.getServer().shutdown()
        }
    }

    private fun kickPlayers() {
        for (player in onlinePlayers) {
            player.kick(Values.PREFIX.append(literalText {
                text("Die Welt wird nun neu generiert.") {
                    color = KColors.GRAY
                }
                newLine()
                text("Deshalb wird der Server neu gestartet.") {
                    italic = true
                    color = KColors.GRAY
                }
                newLine()
                text("Ein neuer Server startet in ") {
                    color = KColors.GRAY
                }
                text("kürze") {
                    color = KColors.GREEN
                }
            }))
            player.kick(
                Component.text(
                    "${Values.PREFIX}§7Die Welt wird neu generiert!\n" +
                            "§o§7Deshalb wird der Server neu gestartet.\n" +
                            "§7Ein neuer Server startet in §akürze§f!"))
        }
    }

    private fun getTimeAsString(time: Int): String {
        val minutes = time % 3600 / 60
        val seconds = time % 60
        return String.format("%02d:%02d ", minutes, seconds)
    }
}