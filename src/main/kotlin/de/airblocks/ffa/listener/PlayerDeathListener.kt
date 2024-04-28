package de.airblocks.ffa.listener

import de.airblocks.ffa.game.GameEngine
import de.airblocks.ffa.kit.KitEngine.currentKit
import de.airblocks.ffa.utils.Values
import net.axay.kspigot.chat.KColors
import net.axay.kspigot.chat.literalText
import net.axay.kspigot.event.listen
import org.bukkit.GameMode
import org.bukkit.event.entity.PlayerDeathEvent

object PlayerDeathListener {
    init {
        listen<PlayerDeathEvent> {
            val player = it.player
            player.killer?.let { it1 -> currentKit.setPlayer(it1) }
            player.killer?.sendMessage(Values.PREFIX.append(literalText {
                text("Du hast ") {
                    color = KColors.SLATEGRAY
                }
                text(player.name) {
                    color = KColors.YELLOWGREEN
                }
                text(" gekillt!")
            }))
            player.sendMessage(Values.PREFIX.append(literalText("Du bist gestorben!") {
                color = KColors.SLATEGRAY
            }))
            player.sendMessage(Values.PREFIX.append(literalText {
                text("Du wurdest von ") {
                    color = KColors.SLATEGRAY
                }
                text(player.name) {
                    color = KColors.YELLOWGREEN
                }
                text(" gekillt!")
            }))
            GameEngine.ingamePlayers.remove(player)
            player.gameMode = GameMode.SPECTATOR
            it.deathMessage(null)
        }
    }
}