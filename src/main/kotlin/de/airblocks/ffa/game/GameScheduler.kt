package de.airblocks.ffa.game

import de.airblocks.ffa.kit.KitEngine
import de.airblocks.ffa.utils.Values
import net.axay.kspigot.chat.KColors
import net.axay.kspigot.chat.literalText
import net.axay.kspigot.extensions.onlinePlayers
import net.kyori.adventure.text.Component
import org.bukkit.Bukkit
import org.bukkit.scheduler.BukkitRunnable

class GameScheduler(
    val resetTime: Int = 60 * 30,
    val kitChangeTime: Int = 5 * 60
): BukkitRunnable() {
    var currentTime = 0; private set
    var kitTime = 0; private set

    override fun run() {
        if(kitTime >= kitChangeTime) {
            //TODO: (new map)
            kitTime = 0
            KitEngine.setNewRandomKit()
        }
        kitTime++
        currentTime++
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
}