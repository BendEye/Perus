package me.bendeye.perus.check;

import lombok.Getter;
import lombok.Setter;

import me.bendeye.perus.Perus;
import me.bendeye.perus.data.PlayerData;
import me.bendeye.perus.manager.AlertManager;

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
    private final Set<Long> flagTimes = new HashSet<>();

    public Check(PlayerData data) {
        this.data = data;
    }

    public void alert(PlayerData data) {
        flagTimes.add(System.currentTimeMillis());

        alertManager.handleAlert(this, String.format("§DPerus §7| §b%player% §5failed §3%checkName% §6%Violation%", data.getPlayer().getName()));
    }

    protected void decreaseVl(int decrement) {
        violations = Math.max(0, violations - decrement);
    }

}
