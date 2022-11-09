package me.bendeye.perus.manager;

import me.bendeye.perus.Perus;
import me.bendeye.perus.check.Check;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PunishmentManager {

    private final ExecutorService executorService = Executors.newFixedThreadPool(4);

    public void handlePunishment(Check check) {
        executorService.submit(() -> {
            check.setMaxviolations(check.getMaxviolations());
            for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                boolean b = check.getViolations() > check.getMaxviolations();
                if (b) {

                    Perus.getInstance().getServer().dispatchCommand(Perus.getInstance().getServer().getConsoleSender(), "kick " + onlinePlayer.getName() );
                }
            }

        });
    }
}
