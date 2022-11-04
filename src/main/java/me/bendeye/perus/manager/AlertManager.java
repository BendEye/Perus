package me.bendeye.perus.manager;

import me.bendeye.perus.check.Check;
import me.bendeye.perus.data.PlayerData;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class AlertManager {

    private final Set<UUID> notifications = new HashSet<>();


    private final ExecutorService executorService = Executors.newFixedThreadPool(4);


    public void toggleAlerts(Player player) {
        UUID uuid = player.getPlayer().getUniqueId();

        if (!notifications.remove(uuid))
            notifications.add(uuid);
    }

    public void handleAlert(Check check) {
        executorService.submit(() -> {
            check.setViolations(check.getViolations() + 1);

            String message = " " + check.getViolations();
                    notifications.stream().map(Bukkit::getPlayer).forEach(player -> player.getPlayer().sendMessage(message));
        });
    }
}