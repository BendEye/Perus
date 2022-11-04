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

    public Check(PlayerData data) {
        this.data = data;
    }

   public void flag() {

    }


}
