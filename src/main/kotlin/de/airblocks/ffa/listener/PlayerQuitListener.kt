package de.airblocks.ffa.listener

import de.airblocks.ffa.utils.Values
import net.axay.kspigot.chat.KColors
import net.axay.kspigot.chat.literalText
import net.axay.kspigot.event.listen
import org.bukkit.GameMode
import org.bukkit.event.player.PlayerQuitEvent

object PlayerQuitListener {
    init {
        listen<PlayerQuitEvent> {
            val player = it.player
            player.gameMode = GameMode.SPECTATOR
            it.quitMessage(Values.PREFIX.append(literalText {
                text(player.name) {
                    color = KColors.GREENYELLOW
                }
                text(" hat das Spiel verlassen.") {
                    color = KColors.SLATEGRAY
                }
            }))
        }
    }
}