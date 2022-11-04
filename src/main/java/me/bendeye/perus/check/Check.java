package me.bendeye.perus.check;

import me.bendeye.perus.data.PlayerData;

public abstract class Check {

    protected final PlayerData data;

    public Check(PlayerData data) {
        this.data = data;
    }
}
