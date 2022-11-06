package me.bendeye.perus.check;

import lombok.Getter;
import lombok.Setter;
import me.bendeye.perus.Perus;
import me.bendeye.perus.data.PlayerData;
import me.bendeye.perus.manager.AlertManager;
import me.bendeye.perus.packet.Packet;
import org.atteo.classindex.IndexSubclasses;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@IndexSubclasses
public abstract class Check {
    private final AlertManager alertManager = Perus.getInstance().getAlertManager();
    protected final PlayerData data;

    protected int violations;
    private final String name;

    // This can be used to check how many times someone set off an alert in an x amount of time
    private final Set<Long> alertTimes = new HashSet<>();

    public Check(PlayerData data, String name) {
        this.data = data;
        this.name = name;
    }

    public void flag(String stats) {
        alertTimes.add(System.currentTimeMillis());
        alertManager.handleAlert(this, Perus.getInstance().getConfigManager().getNotifications()
                .replace("%player%", data.getPlayer().getDisplayName())
                .replace("%check%", name)
                .replace("%vl%", String.valueOf(violations))
                .replace("%stats%", "")
        );


    }

    public void flag(Player player, String stats) {
        alertTimes.add(System.currentTimeMillis());

        alertManager.handleAlert(this, Perus.getInstance().getConfigManager().getNotifications()
                .replace("%player%", data.getPlayer().getDisplayName())
                .replace("%check%", name)
                .replace("%vl%", String.valueOf(violations))
                .replace("%stats%", stats)
        );
    }

    protected void decreaseVl(int decrement) {
        violations = Math.max(0, violations - decrement);
    }

    public abstract void handle(Packet packet);
}

