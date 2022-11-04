package me.bendeye.perus.listener;

import me.bendeye.perus.Perus;
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
        Perus.getInstance().getDataManager().addOrDelete(event.getPlayer());

    }

    @EventHandler
    public void onLogout(PlayerQuitEvent event) {
        Perus.getInstance().getDataManager().addOrDelete(event.getPlayer());
    }
    
}
