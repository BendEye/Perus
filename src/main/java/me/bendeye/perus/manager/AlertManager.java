package me.bendeye.perus.manager;

import lombok.Getter;
import me.bendeye.perus.check.Check;
import me.bendeye.perus.util.ColorUtil;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Getter
public class AlertManager {

    private final Set<UUID> exemptedFromAlerts = new HashSet<>();
    private final ExecutorService executorService = Executors.newFixedThreadPool(4);

    public void toggleAlerts(Player player) {
        UUID uuid = player.getPlayer().getUniqueId();
        if(!exemptedFromAlerts.contains(uuid)) {
            exemptedFromAlerts.add(uuid);
            player.sendMessage(ColorUtil.format("&cYou disabled alerts."));
        } else {
            exemptedFromAlerts.remove(uuid);
            player.sendMessage(ColorUtil.format("&aYou enabled alerts."));
        }
    }

    public void handleAlert(Check check, String format) {
        executorService.submit(() -> {
            check.setViolations(check.getViolations() + 1);
            for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                if(!exemptedFromAlerts.contains(onlinePlayer.getUniqueId()))
                    onlinePlayer.sendMessage(format);
            }

        });



    }
}