package me.bendeye.perus.listener;

import me.bendeye.perus.Perus;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * @author Lindgey
 * made on me.bendeye.perus.listener
 */
public class EventListener implements Listener {

    @EventHandler
    public void onLogin(PlayerJoinEvent event) {
        Player p = event.getPlayer();
        Perus.getInstance().getDataManager().addPlayer(p.getPlayer());

    }

    @EventHandler
    public void onLogout(PlayerQuitEvent event) {
        Player p = event.getPlayer();
        Perus.getInstance().getDataManager().removePlayer(p.getPlayer());
    }
    
}
